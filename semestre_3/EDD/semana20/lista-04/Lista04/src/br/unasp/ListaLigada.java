package br.unasp;

public class ListaLigada {

    /**
     * Ponto de início da lista ligada.
     */
    Elemento raiz;

    /**
     * Insere um novo aluno no final da lista.
     */
    void inserir(Aluno novoAluno) {
        Elemento new_element = new Elemento();
        new_element.alu = novoAluno;
        new_element.proximo = null;

        if (raiz == null) {
            raiz = new_element;
        } else {
            Elemento loop = raiz;
            while (loop.proximo != null) {
                loop = loop.proximo;
            }
            loop.proximo = new_element;
        }
    }

    /**
     * Retorna uma String com os nomes dos alunos entre chaves e separados por vírgulas.
     */
    String imprimir() {
        if (raiz == null) {
            return "{}";
        }

        String resultado = "{";
        Elemento atual = raiz;

        while (atual != null) {
            resultado += atual.alu.nome;
            if (atual.proximo != null) {
                resultado += ", ";
            }
            atual = atual.proximo;
        }

        resultado += "}";
        return resultado;
    }

    /**
     * Calcula a média das notas de um aluno.
     */
    double calcularMedia(Aluno alu) {
        if (alu.notas == null || alu.notas.length == 0) {
            return 0.0;
        }

        double soma = 0.0;
        for (int i = 0; i < alu.notas.length; i++) {
            soma += alu.notas[i];
        }

        return soma / alu.notas.length;
    }

    /**
     * Encontra o aluno com a maior média geral.
     */
    Aluno encontrarMaiorMedia() {
        if (raiz == null) {
            return null;
        }

        Aluno melhorAluno = raiz.alu;
        double maiorMedia = calcularMedia(melhorAluno);

        Elemento atual = raiz.proximo;

        while (atual != null) {
            double mediaAtual = calcularMedia(atual.alu);
            if (mediaAtual > maiorMedia) {
                maiorMedia = mediaAtual;
                melhorAluno = atual.alu;
            }
            atual = atual.proximo;
        }

        return melhorAluno;
    }

    /**
     * Verifica se um aluno com o RA informado existe na lista.
     */
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
