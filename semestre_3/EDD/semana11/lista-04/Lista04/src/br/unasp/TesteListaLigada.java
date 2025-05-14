package br.unasp;

public class TesteListaLigada {

	public static void main(String[] args) {
		testInserirCenario1();
		testInserirCenario2();
		testInserirCenario3();

		testImprimirCenario1();
		testImprimirCenario2();
		testImprimirCenario3();

		testEncontrarMaiorMediaCenario1();
		testEncontrarMaiorMediaCenario2();
		testEncontrarMaiorMediaCenario3();

		testExisteAlunoRACenario1();
		testExisteAlunoRACenario2();
		testExisteAlunoRACenario3();
	}

	public static void testInserirCenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		// Verifica se o aluno foi inserido corretamente na lista
		if (!lista.imprimir().equals("{Joao}")) {
			System.out.println("Teste de inserçao do aluno1 falhou.");
		}
	}

	public static void testInserirCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		// Verifica se os alunos foram inseridos corretamente na lista
		if (!lista.imprimir().equals("{Joao, Maria}")) {
			System.out.println("Teste de inserçao dos alunos1 e 2 falhou.");
		}
	}

	public static void testInserirCenario3() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista = new ListaLigada(); // Cria uma nova lista vazia
		lista.inserir(aluno1);

		// Verifica se o aluno foi inserido corretamente em uma lista vazia
		if (!lista.imprimir().equals("{Joao}")) {
			System.out
					.println("Teste de inserçao do aluno1 em lista vazia falhou.");
		}
	}

	public static void testImprimirCenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		// Verifica se a impressao da lista com um único aluno está correta
		if (!lista.imprimir().equals("{Joao}")) {
			System.out.println("Teste de impressao do cenário 1 falhou.");
		}
	}

	public static void testImprimirCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		// Verifica se a impressao da lista com dois alunos está correta
		if (!lista.imprimir().equals("{Joao, Maria}")) {
			System.out.println("Teste de impressao do cenário 2 falhou.");
		}
	}

	public static void testImprimirCenario3() {
		ListaLigada lista = new ListaLigada();

		// Verifica se a impressao de uma lista vazia está correta
		if (!lista.imprimir().equals("{}")) {
			System.out.println("Teste de impressao do cenário 3 falhou.");
		}
	}

	public static void testEncontrarMaiorMediaCenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		// Verifica se o aluno com maior média é o esperado (aluno1 neste caso)
		if (!alunoMaiorMedia.equals(aluno1)) {
			System.out
					.println("Teste de encontrarMaiorMedia do cenário 1 falhou.");
		}
	}

	public static void testEncontrarMaiorMediaCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		// Verifica se o aluno com maior média é o único aluno na lista
		if (!alunoMaiorMedia.equals(aluno1)) {
			System.out
					.println("Teste de encontrarMaiorMedia do cenário 2 falhou.");
		}
	}

	public static void testEncontrarMaiorMediaCenario3() {
		ListaLigada lista = new ListaLigada();

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		// Verifica se o aluno com maior média é null quando a lista está vazia
		if (alunoMaiorMedia != null) {
			System.out
					.println("Teste de encontrarMaiorMedia do cenário 3 falhou.");
		}
	}

	public static void testExisteAlunoRACenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		// Verifica se o aluno com o RA especificado existe na lista
		if (!lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 1 falhou.");
		}
	}

	public static void testExisteAlunoRACenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		// Verifica se o aluno com o RA especificado existe na lista
		if (!lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 2 falhou.");
		}
	}

	public static void testExisteAlunoRACenario3() {
		ListaLigada lista = new ListaLigada();

		// Verifica se o aluno com o RA especificado nao existe em uma lista vazia
		if (lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 3 falhou.");
		}
	}
}
