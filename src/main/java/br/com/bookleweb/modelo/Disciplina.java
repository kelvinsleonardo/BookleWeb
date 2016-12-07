package br.com.bookleweb.modelo;

import javax.persistence.*;
import java.io.Serializable;


/** Classe Modelo de Disciplina
 * 
 * @author Kelvin Santiago
 *
 */

@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoDisciplina;

	private String nomeDisciplina;

	@ManyToOne
	private Curso curso;

	public Integer getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(Integer codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Disciplina)) {
			return false;
		}
		final Disciplina other = (Disciplina) obj;
		return this.getCodigoDisciplina().equals(other.getCodigoDisciplina());
	}
	
}
	