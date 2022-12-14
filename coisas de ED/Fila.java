public class Fila<T> extends ListaEncadeada<T>{

     public Fila(T info){
        setInicio(info);
     }

     public void enfileira(T info){
        setFinal(info);
     }

     public T desenfileira(){
        return removeInicio();
     }
}
