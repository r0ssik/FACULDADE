public class Binaria {
    public static String baseBinaria(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return baseBinaria(n / 2) + (n % 2);
    }
    
    public static void main(String[] args) {
        System.out.println(baseBinaria(12)); // 1100
        System.out.println(baseBinaria(15)); // 1111
        System.out.println(baseBinaria(91)); // 1011011
    }
}