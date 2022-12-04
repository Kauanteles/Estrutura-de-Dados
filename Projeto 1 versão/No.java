public class No<T>{
  //Atributos 
  private T info;
  private No<T> proximo;

  //Construtor
  public No(T umaInfo, No<T> umProximo){
    this.info = umaInfo;
    this.proximo = umProximo;
  }
  public No(T umaInfo){
    this(umaInfo, null);
  }
  
  //Getters e Setters
  public T getInfo(){
    return this.info;
  }
  public No<T> getProximo(){
    return this.proximo;
  }

  public void setElemento(T umaInfo){
    this.info = umaInfo;
  }
  public void setProximo(No<T> umProximo){
    this.proximo = umProximo;
  }
  
  //Metodos 
  public String toString(){
    String str= "Informção: " + this.getInfo();
    str+= ", Proximo: " + this.getProximo();
    return str;
  }
}