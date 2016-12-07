package br.com.bookleweb.modelo;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Kelvin on 14/11/16.
 */
public enum Perfil implements GrantedAuthority {

    ALUNO, PROFESSOR, ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }


}
