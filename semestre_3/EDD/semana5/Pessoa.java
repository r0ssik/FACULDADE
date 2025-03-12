package semana5;

public class Pessoa {
    int idade;
    String nome;

    public static String retornaVelho(Pessoa[] list){
        int mais_velha = 0;
        String nome_velha = "";
        for(int i = 0; i < list.length; i++){
            Pessoa p = list[i];
            if(p.idade >= mais_velha){
                nome_velha = p.nome;
            }
        }
        System.out.println(nome_velha);
        return nome_velha;
    }
    public static void main(String[] args){
        Pessoa p1 = new Pessoa();
        p1.nome = "Brunno";
        p1.idade = 19;
        Pessoa p2 = new Pessoa();
        p2.idade = 20;
        p2.nome = "João Gabriel";
        Pessoa p3 = new Pessoa();
        p3.idade = 25;
        p3.nome = "Veio da havan";
        Pessoa[] list = {p1, p2, p3};
        retornaVelho(list);
        
    }
}


