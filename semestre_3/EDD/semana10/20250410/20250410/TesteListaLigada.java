public class TesteListaLigada {
  public static void main(String[] args) {
   ListaLigada lista = new ListaLigada();
    
    Pessoa a = new Pessoa();
    a.nome = "Maria";
    a.idade = 30;

    lista.inserir(a);

    Pessoa b = new Pessoa();
    b.nome = "Pedro";
    b.idade = 30;

    lista.inserir(b);
    lista.imprimir();

    System.out.println(lista.imprimirQuantidade());
    //lista.removerInicio();

    lista.removerFinal();
    lista.imprimir();
  }
}