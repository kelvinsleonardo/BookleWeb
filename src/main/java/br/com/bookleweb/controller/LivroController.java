package br.com.bookleweb.controller;

import javax.servlet.http.HttpServletRequest;

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

import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;

import java.util.List;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a Livro.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class LivroController {

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;

	@Autowired
	private LivroRepositorio livroRepositorio;

	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador da
	 * livro.
	 * 
	 * @return ModelAndView - Lista de livros e Disciplinas
	 */
	@RequestMapping(value = "/gerenciadorlivro")
	public ModelAndView gerenciarLivros() {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorlivro");
		mv.addObject("listalivros", livroRepositorio.findAll());
		mv.addObject("listadisciplinas", disciplinaRepositorio.findAll());
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o adicionar novo livro.
	 * 
	 * @param livro - Model livro
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionalivro", method = RequestMethod.POST)
	public ModelAndView adicionarLivro(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");
		//livro.setIsbn(UtilSistema.gerarId());

		Livro livroBanco = livroRepositorio.findByIsbn(livro.getIsbn());

		// Verifica se livro está cadastrado
		if(livroBanco != null){
				String mensagem = "O Livro já está cadastrado.";
				mv.addObject("erro", mensagem);
				return mv;
		}

		if (livroRepositorio.save(livro) != null) {
			String mensagem = "Operação realizada com sucesso.";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ocorreu um erro ao cadastrar livro.";
			mv.addObject("erro", mensagem);
		}

		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o editar livro.
	 * 
	 * @param livro - Model livro
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/editarlivro", method = RequestMethod.POST)
	public ModelAndView editarLivro(@ModelAttribute Livro livro) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");

		Livro livroBanco = livroRepositorio.findByIsbn(livro.getIsbn());
		if(livroBanco.getDisciplinas().size() != 0){
			livro.setDisciplinas(livroBanco.getDisciplinas());
		}

		if (livroRepositorio.save(livro) != null) {
			String mensagem = "Operação realizada com sucesso.";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ocorreu um erro ao editar o livro.";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o remover livro.
	 * 
	 * @param livro - Modelo livro
	 *            
	 * @return ModelAndView - Somente redireciona.
	 */
	@RequestMapping(value = "/removelivro", method = RequestMethod.POST)
	public ModelAndView removerLivro(@ModelAttribute Livro livro) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");
		livroRepositorio.deleteByIsbn(livro.getIsbn());
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador do livro.
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @param livro - Modelo livro            
	 *            
	 * @param opcaopesquisa - Filtrar pelo ISN ou Titulo
	 *            
	 * @return ModelAndView - Retorna uma lista de livros.
	 */
	@RequestMapping(value = "/filtrolivro", method = RequestMethod.POST)
	public ModelAndView filtrarLivro(
			@ModelAttribute Disciplina disciplina, @ModelAttribute Livro livro,
			@RequestParam String opcaopesquisa) {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorlivro");
		opcaopesquisa = opcaopesquisa.toLowerCase();
		List<Livro> listaLivros = new FastArrayList();
		if (opcaopesquisa.equals("isbn")) {

			if(livro.getIsbn() != null){
				Livro livroBanco = livroRepositorio.findByIsbn(livro.getIsbn());
				if(livroBanco != null){
					listaLivros.add(livroBanco);
				}
			}

			mv.addObject("listalivros", listaLivros);

		} else if (opcaopesquisa.equals("titulo")) {
			mv.addObject("listalivros", livroRepositorio.findByTitulo(livro.getTitulo()));
		}
		return mv;
	}

	@RequestMapping(value = "/gerenciadorvinculo")
	public ModelAndView gerenciarVinculos(){
		ModelAndView mv = new ModelAndView("/admin/gerenciadorvinculo");
		mv.addObject("listalivros",livroRepositorio.findAll());
		mv.addObject("listadisciplinas",disciplinaRepositorio.findAll());
		return mv;
	}

	@RequestMapping (value = "/salvarvinculo", method= RequestMethod.POST)
	public ModelAndView salvarVinculo(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
		ModelAndView mv =  new ModelAndView("forward:/gerenciadorvinculo");
		String mensagem;
		Livro livroBanco = livroRepositorio.findByIsbn(livro.getIsbn());

		if(livroBanco.getDisciplinas().contains(disciplina)){
			mensagem = "Já existe um vínculo com essa disciplina.";
			mv.addObject("erro",mensagem);
			return mv;
		}

		// Se não possuir disciplinas então cria uma lista e adiciona a disciplina
		if(livroBanco.getDisciplinas().size() == 0){
			List<Disciplina> listaDisciplinas = new FastArrayList();
			listaDisciplinas.add(disciplina);
			livroBanco.setDisciplinas(listaDisciplinas);
		}else{
			livroBanco.getDisciplinas().add(disciplina);
		}


		if(livroRepositorio.save(livroBanco).getId() != null){
			mensagem = "Operação realizada com sucesso.";
			mv.addObject("sucesso",mensagem);
		}else{
			mensagem = "Ocorreu um erro ao tentar vincular livro";
			mv.addObject("erro",mensagem);
		}

		return mv;

	}

	@RequestMapping(value= "/removervinculo", method= RequestMethod.POST)
	public ModelAndView removerVinculo(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){

		ModelAndView mv =  new ModelAndView("forward:/gerenciadorvinculo");
		String mensagem;
		Livro livroBanco = livroRepositorio.findByIsbn(livro.getIsbn());

		livroBanco.getDisciplinas()
									.removeIf(p -> p.getCodigoDisciplina() == disciplina.getCodigoDisciplina());

		if (livroRepositorio.save(livroBanco).getId() != null) {
			mensagem = "Operação realizada com suceso.";
			mv.addObject("sucesso",mensagem);
		}else{
			mensagem = "Ocorreu um problema ao tentar remover o vinculo.";
			mv.addObject("erro",mensagem);
		}

		return mv;
	}

	@RequestMapping(value= "/buscarvinculos", method= RequestMethod.POST)
	public ModelAndView buscarVinculos(@ModelAttribute Livro livro){
		ModelAndView mv =  new ModelAndView("/admin/gerenciadorvinculo");
		List<Livro> listaLivros = new FastArrayList();
		listaLivros.add(livroRepositorio.findByIsbn(livro.getIsbn()));
		mv.addObject("listalivros",listaLivros);
		mv.addObject("listadisciplinas",disciplinaRepositorio.findAll());
		return mv;
	}

}
