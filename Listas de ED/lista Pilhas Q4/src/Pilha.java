public class Pilha<T> extends ListaEncadeada<T>{

    public Pilha(){}

    public void push(T info){
        setInicio(info);
    }

    public T pop(){
        return removeInicio();
    }

    public T stacktop(Pilha<T> pilha){
        T aux;
        aux = pilha.pop();
        pilha.push(aux);
        return aux;
    }
}
