package br.unasp;

import java.util.Arrays;

/**
 * 
 * Representacao de um aluno, com as informacoes que ele pode 
 * armazenar nos seus campos.
 * 
 * NAO ALTERE ESSA CLASSE!
 *
 */
public class Aluno {
	
	
	
	String nome;
	int ra;
	double[] notas;
	
	
	
	public Aluno(String nome, int ra, double[] notas) {
		super();
		this.nome = nome;
		this.ra = ra;
		this.notas = notas;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Arrays.hashCode(notas);
		result = prime * result + ra;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (!Arrays.equals(notas, other.notas))
			return false;
		if (ra != other.ra)
			return false;
		return true;
	}
	
}
