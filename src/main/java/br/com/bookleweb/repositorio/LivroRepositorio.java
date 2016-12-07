package br.com.bookleweb.repositorio;

import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kelvin on 14/11/16.
 */
@Repository
public interface LivroRepositorio extends CrudRepository<Livro, Integer>  {

    Livro findByIsbn(String isbn);

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByDisciplinas_CodigoDisciplina(Integer codigoDisciplina);

    @Transactional
    Long deleteByIsbn(String isbn);

}
