package br.unasp;

/**
 * 
 * Ponto inicial, com a funcao main para inicio da execucao 
 * e os casos de testes que serao utilizados para validar
 * as implementacoes feitas na classe Operacoes.
 * 
 * NAO ALTERE ESSA CLASSE!
 * 
 * Data de entrega: 13/abr
 *
 */
public class TestePrincipal {

	
	
	public static void main(String[] args) {
		testImprimirComVetorCheio();
		testImprimirComVetorVazio();
		testImprimirComVetorNulo();

		testCalcularMediaComNotasVariadas();
		testCalcularMediaComNotasIguais();
		testCalcularMediaComVetorVazio();

		testEncontrarMaiorMediaComValoresVariados();
		testEncontrarMaiorMediaComTodosIguais();
		testEncontrarMaiorMediaComVetorVazio();

		testExisteAlunoRAComRAExistente();
		testExisteAlunoRAComRANaoExistente();
		testExisteAlunoRAComVetorVazio();

		testAprovadosComNotaCorteVariada();
		testAprovadosComTodosAprovados();
		testAprovadosComVetorVazio();
	}

	
	
	static void testImprimirComVetorCheio() {
		Aluno[] classe = {
				new Aluno("Ana", 123, new double[] { 7.0, 8.5, 9.0 }),
				new Aluno("Beto", 456, new double[] { 5.5, 6.0, 6.5 }) };
		
		String esperado = "{Ana, Beto}";
		
		String resultado = Operacoes.imprimir(classe);
		
		System.out.println("Teste imprimir com vetor cheio: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	
	
	static void testImprimirComVetorVazio() {
		Aluno[] classe = new Aluno[] {};
		
		String esperado = "{}";
		
		String resultado = Operacoes.imprimir(classe);
		
		System.out.println("Teste imprimir com vetor vazio: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}
	
	

	static void testImprimirComVetorNulo() {
		Aluno[] classe = null;
		
		String esperado = "{}";
		
		String resultado = Operacoes.imprimir(classe);
		
		System.out.println("Teste imprimir com vetor nulo: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	
	
	static void testCalcularMediaComNotasVariadas() {
		Aluno alu = new Aluno("Carlos", 789, new double[] { 8.0, 9.0, 10.0 });
		
		double esperado = 9.0;
		
		double resultado = Operacoes.calcularMedia(alu);
		
		System.out.println("Teste calcularMedia com notas variadas: "
						+ (Math.abs(esperado - resultado) < 0.001 ? "Sucesso"
								: "Falha"));
	}
	
	

	static void testCalcularMediaComNotasIguais() {
		Aluno alu = new Aluno("Diana", 101, new double[] { 9.0, 9.0, 9.0 });
		
		double esperado = 9.0;
		
		double resultado = Operacoes.calcularMedia(alu);
		
		System.out.println("Teste calcularMedia com notas iguais: "
						+ (Math.abs(esperado - resultado) < 0.001 ? "Sucesso"
								: "Falha"));
	}
	
	

	static void testCalcularMediaComVetorVazio() {
		Aluno alu = new Aluno("Eva", 202, new double[] {});
		
		double esperado = 0;
		
		double resultado = Operacoes.calcularMedia(alu);
		
		System.out.println("Teste calcularMedia com vetor de notas vazio: "
				+ (esperado == resultado ? "Sucesso" : "Falha"));
	}


	
	static void testEncontrarMaiorMediaComValoresVariados() {
		Aluno[] classe = {
				new Aluno("Ana", 123, new double[] { 7.0, 8.5, 9.0 }),
				new Aluno("Fabio", 456, new double[] { 9.5, 9.0, 9.5 }),
				new Aluno("Gina", 789, new double[] { 10.0, 10.0, 10.0 }) };
		
		Aluno esperado = classe[2];
		
		Aluno resultado = Operacoes.encontrarMaiorMedia(classe);
		
		System.out.println("Teste encontrarMaiorMedia com valores variados: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	static void testEncontrarMaiorMediaComTodosIguais() {
		Aluno[] classe = {
				new Aluno("Hugo", 101, new double[] { 8.0, 8.0, 8.0 }),
				new Aluno("Ivo", 202, new double[] { 8.0, 8.0, 8.0 }) };

		Aluno esperado = classe[0];
		
		Aluno resultado = Operacoes.encontrarMaiorMedia(classe);
		
		System.out.println("Teste encontrarMaiorMedia com todos iguais: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	
	
	static void testEncontrarMaiorMediaComVetorVazio() {
		Aluno[] classe = new Aluno[] {};

		Aluno resultado = Operacoes.encontrarMaiorMedia(classe);
		
		System.out.println("Teste encontrarMaiorMedia com vetor vazio: "
				+ (resultado == null ? "Sucesso" : "Falha"));
	}

	
	
	static void testExisteAlunoRAComRAExistente() {
		Aluno[] classe = {
				new Aluno("Joao", 123, new double[] { 7.0, 8.5, 9.0 }),
				new Aluno("Katia", 456, new double[] { 5.5, 6.0, 6.5 }) };
		
		boolean resultado = Operacoes.existeAlunoRA(classe, 123);
		
		System.out.println("Teste existeAlunoRA com RA existente: "
				+ (resultado ? "Sucesso" : "Falha"));
	}


	
	static void testExisteAlunoRAComRANaoExistente() {
		Aluno[] classe = {
				new Aluno("Lia", 789, new double[] { 7.0, 8.5, 9.0 }),
				new Aluno("Mario", 101, new double[] { 5.5, 6.0, 6.5 }) };
		
		boolean resultado = Operacoes.existeAlunoRA(classe, 999); 

		System.out.println("Teste existeAlunoRA com RA não existente: "
				+ (!resultado ? "Sucesso" : "Falha"));
	}

	
	
	static void testExisteAlunoRAComVetorVazio() {
		Aluno[] classe = new Aluno[] {};
		
		boolean resultado = Operacoes.existeAlunoRA(classe, 123); 

		System.out.println("Teste existeAlunoRA com vetor vazio: "
				+ (!resultado ? "Sucesso" : "Falha"));
	}
	
	
	static void testAprovadosComNotaCorteVariada() {
		Aluno[] classe = {
				new Aluno("Nina", 234, new double[] { 5.0, 7.5, 9.0 }),
				new Aluno("Oscar", 345, new double[] { 4.0, 4.5, 5.0 }),
				new Aluno("Paula", 456, new double[] { 7.0, 8.0, 9.0 }) };

		int notaCorte = 6;

		String esperado = "{Nina, Paula}";

		String resultado = Operacoes.aprovados(classe, notaCorte);

		System.out.println("Teste aprovados com nota corte variada: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	
	
	static void testAprovadosComTodosAprovados() {
		Aluno[] classe = {
				new Aluno("Quim", 567, new double[] { 9.0, 8.5, 9.0 }),
				new Aluno("Rita", 678, new double[] { 7.5, 8.0, 8.5 }) };
		
		int notaCorte = 7;
		
		String esperado = "{Quim, Rita}";
		
		String resultado = Operacoes.aprovados(classe, notaCorte);
		
		System.out.println("Teste aprovados com todos aprovados: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

	
	
	static void testAprovadosComVetorVazio() {
		Aluno[] classe = new Aluno[] {};
		
		int notaCorte = 6;
		
		String esperado = "{}"; 
		
		String resultado = Operacoes.aprovados(classe, notaCorte);
		
		System.out.println("Teste aprovados com vetor vazio: "
				+ (esperado.equals(resultado) ? "Sucesso" : "Falha"));
	}

}
