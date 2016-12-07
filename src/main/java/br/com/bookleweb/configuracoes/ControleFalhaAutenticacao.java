package br.com.bookleweb.configuracoes;

import br.com.bookleweb.modelo.Usuario;
import br.com.bookleweb.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kelvin on 16/11/16.
 */
@Service
public class ControleFalhaAutenticacao implements AuthenticationFailureHandler {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        Usuario usuario = null;
        String erro;
        Boolean isMatriculaVazia = true;

        String matricula = httpServletRequest.getParameter("j_username");
        String senha = httpServletRequest.getParameter("j_password");

        if(!matricula.equals("")){
            usuario = usuarioRepositorio.findOneByMatricula(Integer.parseInt(matricula));
            isMatriculaVazia = false;
        }

        if(usuario == null){
            if(isMatriculaVazia){
                erro = "error=Os campos matr%C3%ADcula e senha devem ser preenchidos.";
            }else{
                erro = "error=Usu%C3%A1rio n%C3%A3o encontrado.";
            }
        }
        else{
            erro = "error=A senha %C3%A9 inv%C3%A1lida.";
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath().concat("/?").concat(erro));

    }
}
