package semana5;

public class ListaDesordenada {
    Pessoa[] valores;
    int qtdElementos;

    ListaDesordenada(int tamanho){
        valores = new Pessoa[tamanho];
        qtdElementos = 0;
    }

    boolean inserir(Pessoa p){
        if(qtdElementos < valores.length){
            valores[qtdElementos] = p;
            qtdElementos += 1;
            return true;
        } else{
            return false;
        }
        
    }
}
