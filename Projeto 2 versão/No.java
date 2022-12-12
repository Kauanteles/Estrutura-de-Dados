public class No<T>{
  //Atributos 
  private T info;
  private No<T> proximo;
  private No<T> anterior;

  //Construtor
  public No(T info, No<T> proximo, No<T> anterior){
    this.info = info;
    this.proximo = proximo;
    this.proximo = anterior;
  }
  public No(T info){
    this(info, null, null);
  }
  
  //Getters e Setters
  public T getInfo(){
    return info;
  }
  public No<T> getProximo(){
    return proximo;
  }
  public No<T> getAnterior(){
    return anterior;
  }

  public void setInfo(T info){
    this.info = info;
  }
  public void setProximo(No<T> proximo){
    this.proximo = proximo;
  }
  public void setAnterior(No<T> anterior){
    this.anterior = anterior;
  }
  
  //Metodos 
  public String toString(){
    String str= "Informção: " + this.getInfo();
    str+= ", Anterior: " + this.getAnterior();
    str+= ", Proximo: " + this.getProximo();
    return str;
  }
}