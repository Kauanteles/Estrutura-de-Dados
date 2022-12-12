public class Fila<T> extends ListaEncadeada<T>{

     public Fila(T info){
        adicionarFinal(info);
     }

     public void enfileira(T info){
        adicionarFinal(info);
     }

     public void desenfileira(T info){
        removeInicio();
     }
}
