public class Collatz {
    public static void imprimeSeqCollatz(int n) {
        if (n <= 0) {
            System.out.println("Erro. Considere apenas números estritamente positivos.");
            return;
        }
        System.out.print(n);
        if (n == 1) {
            System.out.println(".");
            return;
        }
        System.out.print(", ");
        if (n % 2 == 0) {
            imprimeSeqCollatz(n / 2);
        } else {
            imprimeSeqCollatz(3 * n + 1);
        }
    }
    
    public static void main(String[] args) {
        imprimeSeqCollatz(6);
        imprimeSeqCollatz(10);
        imprimeSeqCollatz(-100);
        imprimeSeqCollatz(100);
    }
}
