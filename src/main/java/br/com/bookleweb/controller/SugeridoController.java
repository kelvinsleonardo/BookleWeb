package br.com.bookleweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.bookleweb.repositorio.CursoRepositorio;
import br.com.bookleweb.repositorio.DisciplinaRepositorio;
import br.com.bookleweb.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a livro sugerido da pesquisa que verifica livros disponíveis
 * de acordo com a disciplina.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class SugeridoController {

	@Autowired
	private CursoRepositorio cursoRepositorio;

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;

	@Autowired
	private LivroRepositorio livroRepositorio;

	
	/**
	 * Método Servlet responsável por permitir acesso a página de pesquisa
	 * dos livros sugeridos.
	 * 
	 * @return ModelAndView - Lista de cursos.
	 */
	@RequestMapping(value= "/buscar")
	public ModelAndView buscarSugerido(){
		ModelAndView mv = new ModelAndView("/admin/pesquisa");
		mv.addObject("listacursos",cursoRepositorio.findAll());
		return mv;		
	}
	
	/** Método Servlet responsável por receber um código da disciplina
	 * e retornar todos os livros relacionados aquela disciplina.
	 * 
	 * @param disciplina - Modelo disciplina
	 * @return ModelAndView - Lista de livros relacionadas a disciplina
	 */
	@RequestMapping(value= "/resultado", method= RequestMethod.POST)
	public ModelAndView gerarResultado(@ModelAttribute Disciplina disciplina){
		ModelAndView mv = new ModelAndView("/admin/pesquisaresultado");
		mv.addObject("listalivros", livroRepositorio.findByDisciplinas_CodigoDisciplina(disciplina.getCodigoDisciplina()));
		mv.addObject("disciplina", disciplinaRepositorio.findOne(disciplina.getCodigoDisciplina()));
		return mv;
	}

	/** Método Servlet responsável por retornar uma lista de disciplinas
	 * de acordo com o curso selecionado e fazer um append.
	 * 
	 * @param curso - Modelo curso
	 * @param response - Resposta HTTPServlet
	 * @throws IOException
	 */
	@RequestMapping(value= "/buscardisciplinas", method= RequestMethod.POST)
	public void buscarDisciplinasDoCurso(@ModelAttribute Curso curso, HttpServletResponse response ) throws IOException{
		PrintWriter out = response.getWriter();

		List<Disciplina> listaDisciplinas = disciplinaRepositorio.findByCurso_CodigoCurso(curso.getCodigoCurso());

		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < listaDisciplinas.size(); i++){
			sb.append(listaDisciplinas.get(i).getCodigoDisciplina()+"-"+listaDisciplinas.get(i).getNomeDisciplina()+":");
		}
		out.write(sb.toString());
	}

	
}
