package br.com.bookleweb.modelo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@NamedQueries({
		@NamedQuery(name="Usuario.pesquisaPelaMatricula",
				query="SELECT usu FROM Usuario usu WHERE usu.matricula = :matricula"),
		@NamedQuery(name="Usuario.pesquisaPeloNome",
				query="SELECT usu FROM Usuario usu WHERE usu.nome LIKE :nome"),
		@NamedQuery(name="Usuario.pesquisaTodosUsuarios",
				query="SELECT usu FROM Usuario usu")
})

/** Classe Modelo de Usuario
 *
 * @author Kelvin Santiago
 *
 */

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

	@Id
	private Integer matricula;

	private String nome;

	private String email;

	private String senha;

	private Perfil perfil;

	private String tokenRedefinicaoSenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getTokenRedefinicaoSenha() {
		return tokenRedefinicaoSenha;
	}

	public void setTokenRedefinicaoSenha(String tokenRedefinicaoSenha) {
		this.tokenRedefinicaoSenha = tokenRedefinicaoSenha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> autorizacoes = new ArrayList<GrantedAuthority>();

		autorizacoes.add(getPerfil());

		return autorizacoes;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
