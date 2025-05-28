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

		if (!lista.imprimir().equals("{Joao}")) {
			System.out.println("Teste de inserção do aluno1 falhou.");
		} else {
			System.out.println("SUCESSO: testInserirCenario1");
		}
	}

	public static void testInserirCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		if (!lista.imprimir().equals("{Joao, Maria}")) {
			System.out.println("Teste de inserção dos alunos 1 e 2 falhou.");
		} else {
			System.out.println("SUCESSO: testInserirCenario2");
		}
	}

	public static void testInserirCenario3() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		if (!lista.imprimir().equals("{Joao}")) {
			System.out.println("Teste de inserção do aluno1 em lista vazia falhou.");
		} else {
			System.out.println("SUCESSO: testInserirCenario3");
		}
	}

	public static void testImprimirCenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		if (!lista.imprimir().equals("{Joao}")) {
			System.out.println("Teste de impressão do cenário 1 falhou.");
		} else {
			System.out.println("SUCESSO: testImprimirCenario1");
		}
	}

	public static void testImprimirCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		if (!lista.imprimir().equals("{Joao, Maria}")) {
			System.out.println("Teste de impressão do cenário 2 falhou.");
		} else {
			System.out.println("SUCESSO: testImprimirCenario2");
		}
	}

	public static void testImprimirCenario3() {
		ListaLigada lista = new ListaLigada();

		if (!lista.imprimir().equals("{}")) {
			System.out.println("Teste de impressão do cenário 3 falhou.");
		} else {
			System.out.println("SUCESSO: testImprimirCenario3");
		}
	}

	public static void testEncontrarMaiorMediaCenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		if (!alunoMaiorMedia.equals(aluno1)) {
			System.out.println("Teste de encontrarMaiorMedia do cenário 1 falhou.");
		} else {
			System.out.println("SUCESSO: testEncontrarMaiorMediaCenario1");
		}
	}

	public static void testEncontrarMaiorMediaCenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		if (!alunoMaiorMedia.equals(aluno1)) {
			System.out.println("Teste de encontrarMaiorMedia do cenário 2 falhou.");
		} else {
			System.out.println("SUCESSO: testEncontrarMaiorMediaCenario2");
		}
	}

	public static void testEncontrarMaiorMediaCenario3() {
		ListaLigada lista = new ListaLigada();

		Aluno alunoMaiorMedia = lista.encontrarMaiorMedia();

		if (alunoMaiorMedia != null) {
			System.out.println("Teste de encontrarMaiorMedia do cenário 3 falhou.");
		} else {
			System.out.println("SUCESSO: testEncontrarMaiorMediaCenario3");
		}
	}

	public static void testExisteAlunoRACenario1() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });
		Aluno aluno2 = new Aluno("Maria", 654321, new double[] { 6.5, 8.0, 7.0 });

		lista.inserir(aluno1);
		lista.inserir(aluno2);

		if (!lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 1 falhou.");
		} else {
			System.out.println("SUCESSO: testExisteAlunoRACenario1");
		}
	}

	public static void testExisteAlunoRACenario2() {
		ListaLigada lista = new ListaLigada();
		Aluno aluno1 = new Aluno("Joao", 123456, new double[] { 8.5, 7.0, 9.0 });

		lista.inserir(aluno1);

		if (!lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 2 falhou.");
		} else {
			System.out.println("SUCESSO: testExisteAlunoRACenario2");
		}
	}

	public static void testExisteAlunoRACenario3() {
		ListaLigada lista = new ListaLigada();

		if (lista.existeAlunoRA(123456)) {
			System.out.println("Teste de existeAlunoRA do cenário 3 falhou.");
		} else {
			System.out.println("SUCESSO: testExisteAlunoRACenario3");
		}
	}
}
