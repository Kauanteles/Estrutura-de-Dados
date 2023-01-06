public class Pilha<T> extends ListaEncadeada<T>{

    public Pilha(){}

    public void push(T info){
        setInicio(info);
    }

    public T pop(){
        return removeInicio();
    }

    public T stacktop(){
        T aux;
        aux = this.pop();
        this.push(aux);
        return aux;
    }
}
