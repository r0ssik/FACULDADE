package br.unasp;

public class ListaLigada {

	Elemento raiz;

	// Insere um novo aluno no final da lista
	void inserir(Aluno novoAluno) {
		Elemento novoElemento = new Elemento();
		novoElemento.alu = novoAluno;
		novoElemento.proximo = null;

		if (raiz == null) {
			raiz = novoElemento;
		} else {
			Elemento atual = raiz;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novoElemento;
		}
	}

	// Retorna a representação dos nomes dos alunos na lista
	String imprimir() {
		if (raiz == null) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");

		Elemento atual = raiz;
		while (atual != null) {
			sb.append(atual.alu.nome);
			if (atual.proximo != null) {
				sb.append(", ");
			}
			atual = atual.proximo;
		}

		sb.append("}");
		return sb.toString();
	}

	// Calcula a média das notas de um aluno
	double calcularMedia(Aluno alu) {
		if (alu.notas == null || alu.notas.length == 0) {
			return 0.0;
		}
		double soma = 0.0;
		for (double nota : alu.notas) {
			soma += nota;
		}
		return soma / alu.notas.length;
	}

	// Retorna o aluno com a maior média
	Aluno encontrarMaiorMedia() {
		if (raiz == null) {
			return null;
		}

		Elemento atual = raiz;
		Aluno alunoMaiorMedia = atual.alu;
		double maiorMedia = calcularMedia(alunoMaiorMedia);
		atual = atual.proximo;

		while (atual != null) {
			double mediaAtual = calcularMedia(atual.alu);
			if (mediaAtual > maiorMedia) {
				maiorMedia = mediaAtual;
				alunoMaiorMedia = atual.alu;
			}
			atual = atual.proximo;
		}

		return alunoMaiorMedia;
	}

	// Verifica se existe um aluno com o RA informado
	boolean existeAlunoRA(int ra) {
		Elemento atual = raiz;
		while (atual != null) {
			if (atual.alu.ra == ra) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	}
}
