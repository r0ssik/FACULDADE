Gabriel Rodrigues Rossik -- 075753 

Professor, eu não tinha certeza de como enviar a tarefa, se por docs ou coisa do tipo então decidi enviar os arquivos e classes
já no .zip, vou colocar os códigos aqui também por segurança.




//////////////////////////////////////////////////////////////////////
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

//////////////////////////////////////////////////////////////////////
// Função usando recursividade, já fizemos ela com python antes.

public class Fatorial {
    public static int calcularFatorial(int n) {
        if (n < 0) {
            return -1; 
        }
        
        int fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        
        return fatorial;
    }
// exemplos
    public static void main(String[] args) {
        System.out.println(calcularFatorial(3));  
        System.out.println(calcularFatorial(5));  
        System.out.println(calcularFatorial(-10)); 
    }
}
//////////////////////////////////////////////////////////////////////
public class InverterNumero{
    public static int inverter(int numero) {
        if (numero < 0) {
            return numero;
        }
        
        String numeroStr = Integer.toString(numero); // converte em str
        String numeroInvertidoStr = ""; 
        
        
        for (int i = numeroStr.length() - 1; i >= 0; i--) {
            numeroInvertidoStr += numeroStr.charAt(i); // percorre de trás pra frente e adiciona a outra variavel
        }
        
        return Integer.parseInt(numeroInvertidoStr); // retorna a nova variavel
    }

    public static void main(String[] args) {
        System.out.println(inverter(789));  
        System.out.println(inverter(1005)); 
        System.out.println(inverter(-20));  
    }
}


