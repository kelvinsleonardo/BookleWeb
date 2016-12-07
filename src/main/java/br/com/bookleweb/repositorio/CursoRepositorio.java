package br.com.bookleweb.repositorio;

import br.com.bookleweb.modelo.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kelvin on 14/11/16.
 */
@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Integer>  {

    List<Curso> findByNomeCurso(String nome);

}
