package br.com.bookleweb.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
	@NamedQuery(name="Livro.procuraPeloISBN", 
				query="SELECT liv FROM Livro liv WHERE liv.isbn = :isbn"),
	@NamedQuery(name="Livro.procuraPeloTitulo", 
				query="SELECT liv FROM Livro liv WHERE liv.titulo LIKE :titulo"),
	@NamedQuery(name="Livro.procuraTodosLivros", 
				query="SELECT liv FROM Livro liv ORDER BY liv.titulo ASC"),
	@NamedQuery(name="Livro.procuraTodosLivrosDaRelacao", 
				query="SELECT liv FROM Livro liv JOIN liv.disciplinas disc"),
	@NamedQuery(name="Livro.procuraNaRelacaoPeloCodigoDisciplina", 
				query="SELECT DISTINCT liv FROM Livro liv JOIN liv.disciplinas disc WHERE disc.codigoDisciplina IN :codigoDisciplina"),
	@NamedQuery(name="Livro.procuraNaRelacaoPeloCodigoISBN", 
				query="SELECT DISTINCT liv FROM Livro liv JOIN liv.disciplinas disc WHERE liv.isbn = :isbn")
})

/** Classe Modelo de Livro
 * 
 * @author Kelvin Santiago
 *
 */

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String isbn;

	private String titulo;

	private String autor;

	private String desc_livro;

	private String local;

	private String status;

	private Integer exemplares;
	@ManyToMany
	private List<Disciplina> disciplinas;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDesc_livro() {
		return desc_livro;
	}

	public void setDesc_livro(String desc_livro) {
		this.desc_livro = desc_livro;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getExemplares() {
		return exemplares;
	}

	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}