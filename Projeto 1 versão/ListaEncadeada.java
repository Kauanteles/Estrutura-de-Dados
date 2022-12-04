public class ListaEncadeada<T>{
  //Atributos
  private No<T> cabeca;
  private int tamanho = 0;
  //Construto

  //Metodos 

  //Adiciona um nó na lista (sempre adicionando depois do primeiro elemento)
  public void adicionar(T elemento){
    No<T> info = new No<T>(elemento);
    if(this.cabeca != null){
      info.setProximo(cabeca.getProximo());
      this.cabeca.setProximo(info);
    }
    else this.cabeca = info; 
    
    this.tamanho++;
  }
  //Retorna uma string com informações da lista.
  public String toString(){
    String str = "Tamanho: " + this.getTamanho();
    No<T> aux = new No<T>(cabeca.getInfo(),cabeca.getProximo());
    str+= ", Nós: " + aux.toString();
    for(int i=0; i< getTamanho(); i++){
      aux= aux.getProximo();
      str+= aux.toString();
    }
    return str;
  }

  //Getters e Setters
  public int getTamanho(){
    return this.tamanho;
  }
}