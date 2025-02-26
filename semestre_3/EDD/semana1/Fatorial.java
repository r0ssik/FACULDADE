package semana1;
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
