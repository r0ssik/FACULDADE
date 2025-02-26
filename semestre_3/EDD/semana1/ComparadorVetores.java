package semana1;
public class ComparadorVetores {
    public static boolean saoIdenticos(int[] vetor1, int[] vetor2) {
        if (vetor1.length != vetor2.length) { 
            return false; // comparar largura dos vetores
        }
        
        for (int i = 0; i < vetor1.length; i++) {
            if (vetor1[i] != vetor2[i]) {
                return false; // comparar elementos dos vetores
            }
        }
        
        return true; // se o codigo não para nas verificações anteriores, retorna true
    }

    public static void main(String[] args) {
        int[] vetor1 = {1, 2, 3};
        int[] vetor2 = {1, 2, 3};
        System.out.println(saoIdenticos(vetor1, vetor2)); // true = vetores iguais

        int[] vetor3 = {1, 2};
        int[] vetor4 = {1, 2, 3};
        System.out.println(saoIdenticos(vetor3, vetor4)); // false = vetores diferentes

        int[] vetor5 = {3, 2, 1};
        int[] vetor6 = {1, 2, 3};
        System.out.println(saoIdenticos(vetor5, vetor6)); // false = vetores diferentes
    }
}
