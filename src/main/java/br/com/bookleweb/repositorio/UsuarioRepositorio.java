package br.com.bookleweb.repositorio;

import br.com.bookleweb.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kelvin on 14/11/16.
 */

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.matricula = ?")
	public Usuario findOneByMatricula(Integer matricula);

	List<Usuario> findByNome(String nome);

	Usuario findByEmail(String email);

	Usuario findByTokenRedefinicaoSenha(String token);
	
}
