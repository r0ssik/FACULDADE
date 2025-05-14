package br.unasp;

/**
 * 
 * Esta classe armazena o inicio da lista ligada (definida pelo 
 * atributo raiz) e as operacoes que poderao ser realizadas nos 
 * elementos. 
 * 
 * Sua resolucao deverah ser feita nesta classe.
 *
 */
public class ListaLigada {

	
	
	/**
	 * 
	 * Ponto de inicio da lista ligada.
	 * 
	 * Atencao ao atualizar esta referencia.
	 * 
	 */
	Elemento raiz;
	
	
	
	/**
	 * 
	 * Recebe um novo objeto do tipo Aluno, cria um novo 
	 * Elemento para armazena-lo e o insere na lista ligada
	 * que eh definida a partir da raiz.
	 * 
	 */
	void inserir(Aluno novoAluno) {
		
	}
	
	
	
	/**
	 * 
	 * Retorna uma String contendo os nomes dos alunos, separados 
	 * por virgula e entre chaves, no seguinte formato:
	 * 
	 * {NOME1, NOME2}
	 * 
	 * Os nomes devem ser colocados na ordem em que aparecem na lista.
	 * 
	 * Se a lista estiver vazia, retorne {}.
	 * 
	 */
	String imprimir() {
		return "{}";
	}
	
	
	
	/**
	 * 
	 * Dado um aluno, calcula a media das notas dele e retorna 
	 * este valor encontrado.
	 * 
	 */
	double calcularMedia(Aluno alu) {
		return 0;
	}
	

	
	/**
	 * 
	 * Considerando a lista de alunos armazenadas a partir 
	 * da raiz, calcula a media de cada aluno e encontra o 
	 * aluno de maior media geral. Este aluno (INTEIRO) deve 
	 * ser retornado.
	 * 
	 */
	Aluno encontrarMaiorMedia() {
		return null;
	}
	
	
	
	/**
	 * 
	 * Verifica se um determinado RA existe na lista a partir 
	 * da raiz. Caso exista, retorna true, senao, retorna false.
	 * 
	 * Se a listaestiver vazio, retorna false.
	 * 
	 */
	boolean existeAlunoRA(int ra) {
		return false;
	}
	
}
