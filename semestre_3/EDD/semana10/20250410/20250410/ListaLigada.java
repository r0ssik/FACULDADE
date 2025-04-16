public class ListaLigada {

  Noh inicioLista = null;

  boolean inserir(Pessoa p) {
    Noh novo = new Noh();
    novo.info = p;

    novo.proximo = inicioLista;
    inicioLista = novo;
    return true;
  }

  void imprimir() {
    Noh percorre = inicioLista;
    while (percorre != null) {
      System.out.println(percorre.info.nome);
      percorre = percorre.proximo;
    }
  }

  // metodo que retorna a quantidade de nos
  int imprimirQuantidade() {
    Noh percorre = inicioLista;
    int quantidade = 0;
    while (percorre != null) {
      quantidade += 1;
      percorre = percorre.proximo;
    }
    return quantidade;
  }
 
  // metodo que remove o primeiro elemento
  boolean removerInicio(){
    if(inicioLista == null){
      return false;
    }
    inicioLista = inicioLista.proximo;
    return true;
  }

  // metodo que remove o ultimo elemento
  boolean removerFinal() {
    if (inicioLista == null) {
      return false;
    }
    if (inicioLista.proximo == null) {
      inicioLista = inicioLista.proximo;
      return true;
    }
    Noh percorre = inicioLista;
    while (percorre.proximo.proximo != null) {
      percorre = percorre.proximo;
    }
    percorre.proximo = null;
    return true;
  }
  

}
