public class Fila<T> extends ListaEncadeada<T>{

    //Construtores
    public Fila(){
    }
 
      public Fila(T info){
         setInicio(info);
      }
 
      //metodos enqeue e deqeue
      public void enfileira(T info){
         setFinal(info);
      }
 
      public T desenfileira(){
         return removeInicio();
      }
 }