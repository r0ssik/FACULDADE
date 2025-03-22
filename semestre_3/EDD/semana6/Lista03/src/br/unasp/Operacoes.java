package br.unasp;

/**
 * 
 * Sua resolucao deverah ser feita nesta classe.
 *
 */
public class Operacoes {

	
	
	/**
	 * 
	 * Retorna uma String contendo os nomes dos alunos, separados 
	 * por virgula e entre chaves, no seguinte formato:
	 * 
	 * {NOME1, NOME2}
	 * 
	 * Os nomes devem ser colocados na ordem em que aparecem no vetor.
	 * 
	 * Se o vetor estiver vazio ou nulo, retorne {}.
	 * 
	 */
	static String imprimir(Aluno[] classe) {
		if(classe == null){
			return "{}";
		}
		if(classe.length <= 0){
			return "{}";
		}
		String texto_final = "{";
		for(int i = 0; i < classe.length; i++){
				if(classe.length == 1){
					return "{" + classe[i].nome + "}";
				}
				if(i == classe.length - 1){
					texto_final += classe[i].nome + "}";
					return texto_final;
				}
				
				texto_final += classe[i].nome + "," +  " ";
				
				System.out.println(texto_final);
		}
		return texto_final;
		
	}
	
	
	
	/**
	 * 
	 * Dado um aluno, calcula a media das notas dele e retorna 
	 * este valor encontrado.
	 * 
	 */
	static double calcularMedia(Aluno alu) {
		double sum = 0;
		if (alu.notas.length > 0){
			for(int i = 0; i < alu.notas.length; i++){
				sum += alu.notas[i];
				}
			double media = sum/alu.notas.length;
			return media;
		}
		else{
			return 0;
		}
	}
	

	
	/**
	 * 
	 * Dado um vetor representando os alunos de uma sala, 
	 * calcula a media de cada aluno e encontra o aluno de 
	 * maior media geral. Este aluno (INTEIRO) deve ser 
	 * retornado.
	 * 
	 */
	static Aluno encontrarMaiorMedia(Aluno[] classe) {
		if (classe.length > 0){
			return null;
		}
		Aluno pessoa_final = null;
		double media_final = 0;
		for(int i1 = 0; i1 < classe.length; i1++){
			Aluno pessoa = classe[i1];
			double soma = 0;
			for (int i2 = 0; i2 < pessoa.notas.length; i2++){
				soma += pessoa.notas[i2];
			}
			double media = soma/pessoa.notas.length;
			if(media > media_final){
				media_final = media;
				pessoa_final = pessoa;
			}
		
		}
		return pessoa_final;
	}
	
	
	
	/**
	 * 
	 * Verifica se um determinado RA existe numa classe de diversos 
	 * alunos. Caso exista, retorna true, senao, retorna false.
	 * 
	 * Se o vetor estiver vazio ou nulo, retorna false.
	 * 
	 */
	static boolean existeAlunoRA(Aluno[] classe, int ra) {
		return false;
	}
	
	
	
	/**
	 * 
	 * Dado um vetor de alunos, representando uma classe e uma 
	 * certa nota de corte, retorna os nomes de todos os alunos 
	 * que teriam sido aprovados baseado em suas medias.
	 * 
	 * Seguir a formatacao da funcao imprimir.
	 * 
	 */
	static String aprovados(Aluno[] classe, double notaCorte) {
		return "{}";
	}
}
