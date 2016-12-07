package br.com.bookleweb.controller;

import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;
import br.com.bookleweb.repositorio.CursoRepositorio;
import br.com.bookleweb.repositorio.DisciplinaRepositorio;
import br.com.bookleweb.repositorio.LivroRepositorio;
import org.apache.commons.collections.FastArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a Curso.
 *
 * @author Kélvin Santiago
 */
@Controller
public class CursoController {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    @Autowired
    private LivroRepositorio livroRepositorio;

    /**
     * Método Servlet responsável por permitir acesso a página do gerenciador de
     * curso.
     *
     * @return ModelAndView - Lista com todos os cursos
     */
    @RequestMapping(value = "/gerenciadorcurso")
    public ModelAndView gerenciarCurso() {
        ModelAndView mv = new ModelAndView("/admin/gerenciadorcurso");
        mv.addObject("listacursos", cursoRepositorio.findAll());
        return mv;
    }

    /**
     * Método Servlet responsável por controlar o adicionar novo curso entre o
     * JSP e o DAO.
     *
     * @param curso - Model curso
     * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
     */
    @RequestMapping(value = "/adicionacurso", method = RequestMethod.POST)
    public ModelAndView adicionarCurso(@ModelAttribute Curso curso) {
        ModelAndView mv = new ModelAndView("forward:/gerenciadorcurso");
        if (cursoRepositorio.save(curso).getCodigoCurso() != 0) {
            String mensagem = "Opa! Curso adicionado com Sucesso!";
            mv.addObject("sucesso", mensagem);
        } else {
            String mensagem = "Ixi! Erro ao cadastrar curso!";
            mv.addObject("erro", mensagem);
        }
        return mv;
    }

    /**
     * Método Servlet responsável por controlar o editar curso entre o JSP e o
     * DAO.
     *
     * @param curso - Model curso
     * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
     */
    @RequestMapping(value = "/editacurso", method = RequestMethod.POST)
    public ModelAndView editarCurso(@ModelAttribute Curso curso) {
        ModelAndView mv = new ModelAndView("forward:/gerenciadorcurso");
        if (cursoRepositorio.save(curso) != null) {
            String mensagem = "Opa! Curso editado com Sucesso!";
            mv.addObject("sucesso", mensagem);
        } else {
            String mensagem = "Ixi! Erro ao editar curso!";
            mv.addObject("erro", mensagem);
        }
        return mv;
    }

    /**
     * Método Servlet responsável por controlar o remover curso entre o JSP e o
     * DAO.
     *
     * @param curso - Model curso
     * @return ModelAndView - Somente redireciona.
     */
    @RequestMapping(value = "/removecurso", method = RequestMethod.POST)
    public ModelAndView removerCurso(@ModelAttribute Curso curso) {
        ModelAndView mv = new ModelAndView("forward:/gerenciadorcurso");

        List<Disciplina> listaDisciplinas = disciplinaRepositorio.findByCurso_CodigoCurso(curso.getCodigoCurso());

        for (Disciplina disciplina : listaDisciplinas) {

            List<Livro> listaLivros = livroRepositorio.findByDisciplinas_CodigoDisciplina(disciplina.getCodigoDisciplina());

            for (Livro livro : listaLivros) {
                livro.getDisciplinas()
                        .removeIf(p -> p.getCodigoDisciplina() == disciplina.getCodigoDisciplina());
                livroRepositorio.save(livro);
            }

            disciplinaRepositorio.delete(disciplina);
        }

        cursoRepositorio.delete(curso);

        return mv;
    }

    /**
     * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
     * gerenciador do curso.
     *
     * @param curso       - Model curso
     * @param opcaofiltro - Filtrar pelo Codigo ou Nome
     * @return ModelAndView - Retorna uma lista com os cursos de acordo com o
     * filtro.
     */
    @RequestMapping(value = "/filtrocurso", method = RequestMethod.POST)
    public ModelAndView filtrarCurso(@ModelAttribute Curso curso,
                                     @RequestParam String opcaofiltro) {
        ModelAndView mv = new ModelAndView("/admin/gerenciadorcurso");
        List<Curso> lista = new FastArrayList();

        opcaofiltro = opcaofiltro.toLowerCase();
        if (opcaofiltro.equals("codigo")) {

            if(curso.getCodigoCurso() != null){
                lista.add(cursoRepositorio.findOne(curso.getCodigoCurso()));
            }

            mv.addObject("listacursos", lista);

        } else if (opcaofiltro.equals("nome")) {
            mv.addObject("listacursos", cursoRepositorio.findByNomeCurso(curso.getNomeCurso()));
        }
        return mv;
    }

}
