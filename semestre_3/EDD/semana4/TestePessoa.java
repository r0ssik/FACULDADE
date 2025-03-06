package semana4;

public class TestePessoa {
    public static void main(String[] args){
        Pessoa p = new Pessoa();
        p.nome = "Maria";
        p.idade = 55;
        p.tel = new Telefone();
        p.tel.ddd = 19;
        p.tel.pref = 12345;
        p.tel.mcdu = 1234;

        System.out.println(p.nome + "," + p.idade);
        System.out.println("+55 " + p.tel.ddd + " " + p.tel.pref + "-" + p.tel.mcdu);
    }

    static int maisVelha(Pessoa[] sala){
        int idx = 0;
        int idadeVelha = 0;
        for (int i = 0; i < sala.length; ++i){
            if(sala[i].idade > idadeVelha){
                idx = i;
                idadeVelha = sala[i].idade;
            }    
        }
        return idx;
    }
}
