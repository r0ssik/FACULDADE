public class OiMundo {
    public static void main(String[] args) {
        System.out.println("Oi mundo");
        int[] valores = {1, 2, 3};
        print(valores);
    }

    public static void print(int[] dados){
        for (int i=0;i < dados.length; ++i){
            System.out.println(dados[i]);
        }
    }
}
