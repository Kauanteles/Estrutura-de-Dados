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

  // Metodos

  // Adiciona um novo nó no fim da lista
  public void adicionarFinal(T elemento) {
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
  public void adicionarPosicaoN(T elemento, int posicao) {
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
  public T removeFinal() {
    if (estaVazia()) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    } 
      T valor = cauda.getInfo();

      if (estaVazia()) {
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
  public T removeInicio() {
    if (estaVazia()) {
      System.out.println("erro, não pode remover de uma lista vazia!\n");
      System.exit(-1);
    }

    T valor = cabeca.getInfo();

    if (estaVazia()) {
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
    if (!tamanhoValido(posicao)) {
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

  // Retorna uma string com informações da lista.
  public String toString() {
    No<T> aux = new No<T>(cabeca.getInfo(), cabeca, cabeca.getProximo());
    String str = "Nós: ";
    if (aux == cauda) {
      return str + aux.getInfo() + "\nTamanho: " + getTamanho();
    } else {
      str += aux.getInfo();
      aux = aux.getProximo();
      return str += ", " + aux.toString();
    }
  }

  // checa se a lista esta vazia
  private boolean estaVazia() {
    if (cabeca == null && cauda == null) {
      return true;
    } else
      return false;
  }

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
}