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

    Pessoa c = new Pessoa();
    c.nome = "João";
    c.idade = 30;

    lista.inserir(c);
    lista.imprimir();

    System.out.println(lista.imprimirQuantidade());
    lista.removerInicio();
    lista.imprimir();
    System.out.println(lista.imprimirQuantidade());
    lista.removerFinal();
    System.out.println(lista.imprimirQuantidade());
    lista.imprimir();
  }
}