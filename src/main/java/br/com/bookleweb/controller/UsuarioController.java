package br.com.bookleweb.controller;

import br.com.bookleweb.modelo.Perfil;
import br.com.bookleweb.modelo.Usuario;
import br.com.bookleweb.repositorio.UsuarioRepositorio;
import br.com.bookleweb.servicos.ServicoEmail;
import br.com.bookleweb.util.Criptografia;
import br.com.bookleweb.util.UtilSistema;
import org.apache.commons.collections.FastArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a usuario do sistema.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private ServicoEmail servicoEmail;

	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador
	 * de usuários.
	 * 
	 * @return ModelAndView - Lista de usuarios
	 */
	@RequestMapping(value = "/gerenciadorusuario")
	public ModelAndView gerenciarUsuario() {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorusuario");
		mv.addObject("listausuarios", usuarioRepositorio.findAll());
		return mv;
	}
	/**
	 * Método Servlet responsável por controlar o adicionar novo usuario.
	 * 
	 * @param usuario - Modelo usuario. 
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionausuario", method = RequestMethod.POST)
	public ModelAndView adicionarUsuario(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorusuario");

		if(usuarioRepositorio.exists(usuario.getMatricula())){
			String mensagem = "Já existe um usuário cadastrado com esse CPF.";
			mv.addObject("erro", mensagem);
		}else{
			usuario.setSenha(Criptografia.bCryptEncoder(usuario.getSenha()));
			usuarioRepositorio.save(usuario);
			String mensagem = "Operação realizada com sucesso.";
			mv.addObject("sucesso", mensagem);
		}
		return mv;
	}

	/** Controlador Servlet responsável por adicionar usuário, é verificado
	 * a quantidade de dígitos, se for menor ou igual a 6 é adicionado o privilégio
	 * de aluno, senão é setado o privilégio de professor.
	 * 
	 * @param usuario
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionausuariologin", method = RequestMethod.POST)
	public ModelAndView adicionarUsuarioPublico(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView("forward:/login");
		usuario.setSenha(Criptografia.bCryptEncoder(usuario.getSenha()));
		if (usuarioRepositorio.exists(usuario.getMatricula())) {
			String mensagem = "Já existe um usuário cadastrado com essa matrícula.";
			mv.addObject("erro", mensagem);
		} else {
			Integer quantidadeDigitos = Long
					.toString(usuario.getMatricula()).length();
			if (quantidadeDigitos < 7) {
				usuario.setPerfil(Perfil.ALUNO);
			} else {
				usuario.setPerfil(Perfil.PROFESSOR);
			}

			if (usuarioRepositorio.save(usuario) != null) {
				String mensagem = "Operação realizada com sucesso! Faça Login!";
				mv.addObject("sucesso", mensagem);
			} else {
				String mensagem = "Ocorreu um erro ao cadastrar o usuário.";
				mv.addObject("erro", mensagem);
			}
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o editar usuario.
	 * 
	 * @param usuario - Modelo usuario
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/editausuario", method = RequestMethod.POST)
	public ModelAndView editarUsuario(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorusuario");
		Usuario usuarioEditado = usuarioRepositorio.findOneByMatricula(usuario.getMatricula());
		usuario.setSenha(usuarioEditado.getSenha());
		if (usuarioRepositorio.save(usuario) != null) {
			String mensagem = "Opa! Usuario editado com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao editar usuario!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o alterarsenha do usuario.
	 * 
	 * @param usuario - Modelo usuario
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro e redireciona para Gerenciador do Usuario.
	 */
	@RequestMapping(value = "/alterasenha", method = RequestMethod.POST)
	public ModelAndView alterarSenha(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorusuario");
		Usuario usuarioNovo = usuarioRepositorio.findOneByMatricula(usuario.getMatricula());
		usuarioNovo.setSenha(Criptografia.bCryptEncoder(usuario.getSenha()));
		if (usuarioRepositorio.save(usuarioNovo) != null) {
			String mensagem = "Opa! Senha alterada com sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao alterar senha do usuario!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o alterarsenha do usuario.
	 * 
	 * @param usuario - Modelo usuario
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro e redireciona para Login.
	 */
	@RequestMapping(value = "/alterasenhamenu", method = RequestMethod.POST)
	public ModelAndView alteraSenhaPerfil(@ModelAttribute Usuario usuario) {
		ModelAndView mv;
		Usuario usuarioNovo = usuarioRepositorio.findOneByMatricula(usuario.getMatricula());
		usuarioNovo.setSenha(Criptografia.bCryptEncoder(usuario.getSenha()));
		if (usuarioRepositorio.save(usuarioNovo) != null) {
			String mensagem = "Opa! Senha alterada com sucesso!";
			mv = new ModelAndView("forward:/admin");
			mv.addObject("sucesso", mensagem);
		} else {
			mv = new ModelAndView("forward:/admin");
			String mensagem = "Ixi! Erro ao alterar senha do usuario!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o remover usuario.
	 * 
	 * @param usuario - Modelo usuario
	 *            
	 * @return ModelAndView - Somente redireciona para Gerenciador do Usuario.
	 */
	@RequestMapping(value = "/removeusuario", method = RequestMethod.POST)
	public ModelAndView removerUsuario(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorusuario");
		usuarioRepositorio.delete(usuario);
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador do livro.
	 * 
	 * @param usuario - Modelo usuario
	 *         
	 * @param opcaopesquisa - Seleciona a busca pela matrícula ou pelo nome.       
	 *            
	 * @return ModelAndView - Retorna uma lista de usuarios de acordo com o filtro.
	 */
	@RequestMapping(value = "/pesquisausuario", method = RequestMethod.POST)
	public ModelAndView buscarUsuario(@ModelAttribute Usuario usuario,
			@RequestParam String opcaopesquisa) {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorusuario");
		List<Usuario> list = new FastArrayList();

		opcaopesquisa = opcaopesquisa.toLowerCase();

		if (opcaopesquisa.equals("matricula")) {
			Usuario usuarioBanco = usuarioRepositorio.findOneByMatricula(usuario.getMatricula());
			if(usuarioBanco != null){
				mv.addObject("listausuarios",list);
			}
		} else if (opcaopesquisa.equals("nome")) {
			mv.addObject("listausuarios", usuarioRepositorio.findByNome(usuario.getNome()));
		}
		return mv;
	}

	@RequestMapping(value = "/solicitarsenha", method = RequestMethod.POST)
	public ModelAndView solicitarsenha(@RequestParam String email, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/publico/solicitarsenha");

		boolean sucesso = true;

		Usuario usuario = usuarioRepositorio.findByEmail(email);

		if(usuario == null){
			sucesso = false;
			mv.addObject("retorno",sucesso);
		}else{
			String token = UtilSistema.gerarToken();
			usuario.setTokenRedefinicaoSenha(token);
			usuarioRepositorio.save(usuario);

			mv.addObject("retorno",sucesso);
			String assunto = "Redefinição de senha - BookleWeb";
			String texto = "Olá "+usuario.getNome()+
			  			   "<br/>"+
			 			   "Você solicitou a redefinição de senha no sistema BookleWeb, caso " +
					       " não seja você que solicitou, ignore esta mensagem." +
					       "<br/>"+
			               "<br/>"+
					       "Link:"+request.getRequestURL().toString().split("solicitarsenha")[0].concat("validartoken/").concat(token);

			servicoEmail.enviar(assunto,texto,email);

		}

		mv.addObject("email",email);
		return mv;

	}

	@RequestMapping(value = "/validartoken/{token}", method = RequestMethod.GET)
	public ModelAndView validarToken(@PathVariable String token, HttpServletRequest request){
		ModelAndView mv;

		Usuario usuario = usuarioRepositorio.findByTokenRedefinicaoSenha(token);

		if(usuario == null){
			mv = new ModelAndView("redirect:/");
			mv.addObject("error", "O token de redefinição de senha é inválido!");
			return mv;
		}else{
			mv = new ModelAndView("/publico/redefinirsenha");
			mv.addObject("usuario",usuario);
		}

		return mv;

	}

	@RequestMapping(value = "/redefinirsenha", method = RequestMethod.POST)
	public ModelAndView validarToken(@ModelAttribute Usuario usuario){
		ModelAndView mv = new ModelAndView("/publico/redefinirsenha");

		Usuario usuarioNovo = usuarioRepositorio.findOneByMatricula(usuario.getMatricula());

		usuarioNovo.setSenha(Criptografia.bCryptEncoder(usuario.getSenha()));
		usuarioNovo.setTokenRedefinicaoSenha(null);

		usuarioRepositorio.save(usuarioNovo);

		Boolean senhaalterada = true;

		mv.addObject("senhaalterada", senhaalterada);

		return mv;

	}

}
