public class ListaEncadeada<T> {
  // Atributos
  private No<T> cabeca;
  private No<T> cauda;
  private int tamanho = 0;

  // Construtores
  public ListaEncadeada() {
    cabeca = null;
    cauda = null;
  }

  public ListaEncadeada(T info) {
    this();
    adicionarFinal(info);
  }

  // Metodos

  // Adiciona um novo nó no fim da lista
  private void adicionarFinal(T elemento) {
    No<T> novoNo = new No<T>(elemento);
    if (estaVazia()) {
      cabeca = novoNo;
      cauda = novoNo;
    } else {
      cauda.setProximo(novoNo);
      novoNo.setAnterior(cauda);
      cauda = novoNo;
    }
    tamanho++;
  }

  // Adiciona um novo nó no inicio da lista
  public void adicionarInicio(T elemento) {
    No<T> novoNo = new No<T>(elemento);
    if (estaVazia()) {
      cabeca = novoNo;
      cauda = novoNo;
    } else {
      cabeca.setAnterior(novoNo);
      novoNo.setProximo(cabeca);
      cabeca = novoNo;
    }
    tamanho++;
  }

  // Adiciona um novo nó à posição passada como parametro
  private void adicionarPosicaoN(T elemento, int posicao) {
    if (tamanhoValido(posicao)) {
      if (posicao == 1) {
        adicionarInicio(elemento);
        return;
      } else {
        if (posicao == tamanho) {
          adicionarFinal(elemento);
          return;
        } else {
          No<T> novoNo = new No<T>(elemento);
          No<T> aux = cabeca;
          int i;

          for (i = 1; i < posicao - 1; i++) {
            aux = aux.getProximo();
          }

          novoNo.setProximo(aux.getProximo());
          novoNo.setAnterior(aux.getAnterior().getProximo());
          aux.getProximo().setAnterior(novoNo);
          aux.getAnterior().getProximo().setProximo(novoNo);
          aux = null;
        }
      }
    } else {
      System.exit(-1);
    }
  }

  // remove o ultimo elemento
  protected T removeFinal() {
    if (estaVazia()) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    }
    T valor = cauda.getInfo();

    if (cabeca == cauda) {
      cabeca = null;
      cauda = null;
      tamanho = 0;
      return valor;
    } else {
      No<T> aux = cauda;
      cauda = aux.getAnterior();
      cauda.setProximo(null);
      aux = null;
      tamanho--;
      return valor;
    }

  }

  // remove o primeiro elemento
  protected T removeInicio() {
    if (estaVazia()) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    }

    T valor = cabeca.getInfo();

    if (cabeca == cauda) {
      cabeca = null;
      cauda = null;
      tamanho = 0;
      return valor;
    } else {
      No<T> aux = cabeca;
      cabeca = aux.getProximo();
      cabeca.setAnterior(null);
      aux = null;
      tamanho--;
      return valor;
    }
  }

  // remove o elemento na posição passada por parametro
  public T removePosicaoN(int posicao) {
    if (estaVazia()) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    }
    if (tamanhoValido(posicao) == false) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    }

    if (posicao == 1) {
      return removeInicio();
    } else {
      if (posicao == tamanho) {
        return removeFinal();
      } else {
        No<T> aux = cabeca;

        for (int i = 1; i < posicao; i++) {
          aux = aux.getProximo();
        }
        T valor = aux.getInfo();

        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());
        aux = null;
        tamanho--;
        return valor;
      }
    }
  }

  // retorna verdadeiro se a remocao ocorreu
  public boolean remocaoSucedida(T info) {
    int cont=1;
    if (estaVazia()) {
      return false;
    } else {
      while (cabeca != null) {
        cont++;
        if (info == cabeca.getInfo()) {
          removePosicaoN(cont);
          return true;
        }
        cabeca = cabeca.getProximo();
      }
      return false;
    }
  }

  // Retorna uma string com informações da lista.
  public String toString() {
    String str = "integrantes da Lista: ";
    return str + imprimeNo(cabeca, cauda);
  }

  // imprime um no especifico
  private String imprimeNo(No<T> No1, No<T> No2) {
    String str = null;
    if (No1 == null) {
      System.out.println("Erro, não pode imprimir uma lista vazia");
      System.exit(-1);
    }
    while (No1 != null) {
      str += No1.getInfo().toString();
      No1 = No1.getProximo();
    }
    return str;
  }

  // checa se a lista esta vazia
  private boolean estaVazia() {
    if (cabeca == null && cauda == null) {
      return true;
    } else
      return false;
  }

  // checa se a posicao da lista passada por parametro condiz com o tamanho dela
  private boolean tamanhoValido(int posicao) {
    if (posicao > this.tamanho || posicao < 1) {
      return false;
    } else
      return true;
  }

  // Getters e Setters
  public int getTamanho() {
    return this.tamanho;
  }

  public void setInicio(T info) {
    adicionarInicio(info);
  }

  public void setFinal(T info) {
    adicionarFinal(info);
  }

  public void setPosicaoN(T info, int posicao) {
    adicionarPosicaoN(info, posicao);
  }
}