package semana1;
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
