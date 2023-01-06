//classe Node
public class Node<T>{
    //Atributos da classe Node
    public T data; //Objeto generico que o nó armazena
    public Node<T> next; //Nó para o proximo objeto

    //Construtor que recebe um dado generico
    Node(T data){
        this.data = data;
        this.next = null;
    }//fim
    Node(){
        this.data = null;
        this.next = null;
    }
}//Fim classe Node