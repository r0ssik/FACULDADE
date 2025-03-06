package semana3;
public class Teste{
    public static void main(String[] args){
        imprimir(20);
    }

    static void imprimir(int num){
        if (num < 0){
            return;
        }
        imprimir(num - 1);
        System.out.println(num);
    }
}