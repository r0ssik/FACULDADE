public class ApenasCaracteres {
    public static boolean isNumero(String str) {
        if (str.isEmpty()) {
            return true;
        }
        char primeiro = str.charAt(0);
        if (!Character.isDigit(primeiro)) {
            return false;
        }
        return isNumero(str.substring(1));
    }
    
    public static void main(String[] args) {
        System.out.println(isNumero("123456")); // true
        System.out.println(isNumero("123456A")); // false
        System.out.println(isNumero("A983B")); // false
    }
}