package br.com.bookleweb.repositorio;

import br.com.bookleweb.modelo.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kelvin on 14/11/16.
 */
@Repository
public interface DisciplinaRepositorio extends CrudRepository<Disciplina, Integer>  {

    List<Disciplina> findByNomeDisciplina(String nome);

    List<Disciplina> findByCurso_CodigoCurso(Integer codigoCurso);

}
