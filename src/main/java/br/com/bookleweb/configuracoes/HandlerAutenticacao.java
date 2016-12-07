package br.com.bookleweb.configuracoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bookleweb.modelo.Perfil;
import br.com.bookleweb.modelo.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import org.springframework.stereotype.Component;

/** Classe Responsável por ter métodos de Sucesso depois da autenticação 
 * do login feito pelo Framework Spring Security
 * 
 * @author Kelvin Santiago
 *
 */
@Component
public class HandlerAutenticacao implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response,
										Authentication authentication)
										throws IOException, ServletException {

		SecurityContextHolder.getContext().getAuthentication();

		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		// Criando sessão para guardar nome do usuario
		request.getSession().setAttribute("nome_usuario_sessao", usuario.getNome());

		// Obtendo URL da request
		String URL = request.getRequestURL().toString().split("j_spring_security_check")[0];

		// De acordo com o tipo de permissão é redirecionado para a página relacionada.
		if (usuario.getAuthorities().contains(Perfil.ALUNO)) {
			response.sendRedirect(URL.concat("aluno"));
		}else if (usuario.getAuthorities().contains(Perfil.PROFESSOR)){
			response.sendRedirect(URL.concat("professor"));
		}else if  (usuario.getAuthorities().contains(Perfil.ADMIN)){
			response.sendRedirect(URL.concat("admin"));
		}
	}
}