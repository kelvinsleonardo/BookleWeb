package br.com.bookleweb.controller;

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

import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

import java.util.List;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a Disciplina.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class DisciplinaController {

	@Autowired
	private LivroRepositorio livroRepositorio;

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;

	@Autowired
	private CursoRepositorio cursoRepositorio;


	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador da
	 * disciplina.
	 * 
	 * @return ModelAndView - Lista de cursos e Disciplinas
	 */
	@RequestMapping(value = "/gerenciadordisciplina")
	public ModelAndView gerenciarDisciplina() {
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
		mv.addObject("listadisciplinas", disciplinaRepositorio.findAll());
		mv.addObject("listacursos", cursoRepositorio.findAll());
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o adicionar nova disciplina.
	 * 
	 * @param curso - Model curso.
	 *   
	 * @param disciplina - Model disciplina.     
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionadisciplina", method = RequestMethod.POST)
	public ModelAndView adicionarDisciplina(
			@ModelAttribute Disciplina disciplina, @ModelAttribute Curso curso) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");

		disciplina.setCurso(curso);

		if (disciplinaRepositorio.save(disciplina) != null) {
			String mensagem = "Opa! Disciplina adicionada com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao cadastrar disciplina!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o editar disciplina.
	 * 
	 * @param disciplina - Model disciplina
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/editadisciplina", method = RequestMethod.POST)
	public ModelAndView editarDisciplina(@ModelAttribute Disciplina disciplina,
			@ModelAttribute Curso curso) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");

		disciplina.setCurso(curso);

		if (disciplinaRepositorio.save(disciplina) != null) {
			String mensagem = "Opa! Disciplina editada com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao editar disciplina!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o remover disciplina.
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @return ModelAndView - Somente redireciona.
	 */
	@RequestMapping(value = "/removedisciplina", method = RequestMethod.POST)
	public ModelAndView removerDisciplina(@ModelAttribute Disciplina disciplina) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");

		List<Livro> listaLivros = livroRepositorio.findByDisciplinas_CodigoDisciplina(disciplina.getCodigoDisciplina());

		for(Livro livro : listaLivros){

			livro.getDisciplinas()
					.removeIf(p -> p.getCodigoDisciplina() == disciplina.getCodigoDisciplina());
			livroRepositorio.save(livro);
		}

		disciplinaRepositorio.delete(disciplina);
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador do curso.
	 * 
	 * @param disciplina - Model disciplina
	 *            
	 * @param opcaopesquisa - Filtrar pelo Codigo ou Nome
	 *            
	 * @return ModelAndView - Retorna uma lista de cursos e disciplinas.
	 */
	@RequestMapping(value = "/pesquisadisciplina", method = RequestMethod.POST)
	public ModelAndView pesquisarDisciplina(
			@ModelAttribute Disciplina disciplina,
			@RequestParam String opcaopesquisa) {
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
		List<Disciplina> listaDisciplina = new FastArrayList();

		opcaopesquisa = opcaopesquisa.toLowerCase();
		if (opcaopesquisa.equals("codigo")) {

			if(disciplina.getCodigoDisciplina() != null) {
				Disciplina disciplinaBanco = disciplinaRepositorio.findOne(disciplina.getCodigoDisciplina());

				if(disciplinaBanco != null){
					listaDisciplina.add(disciplinaBanco);
				}
			}

			mv.addObject("listadisciplinas",listaDisciplina);
		} else if (opcaopesquisa.equals("nome")) {
			mv.addObject("listadisciplinas",
					disciplinaRepositorio.findByNomeDisciplina(	disciplina.getNomeDisciplina()));
		}
		mv.addObject("listacursos", cursoRepositorio.findAll());
		return mv;
	}

}
