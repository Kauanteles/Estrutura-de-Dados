//Classe generica para uma lista encadeada
public class List<T extends Comparable<T>> implements ListInterface<T>{
    //Atributos da classe List
    private int size = 0; //Guarda o tamanho da lista
    private Node<T> tail; //Primero item da lista

    //Construtor
    public List(){
        this.tail = null;
    }//Fim

    public T getPosition(int n){
        Node<T> aux = tail.next;
        for(int i = 1; i < n; i++){
            aux = aux.next;
        }

        return aux.data;
    }

    public T getLast(){
        return tail.data;
    }

    //Metodo getSizeList para obter o tamanho da lista
    public int getSizeList(){
        return this.size;
    }//Fim getSizeList

    //Função para setar um item no começo da lista
    public void setFrontList(T data){
        T d = data;
        d = data;
        insertFront(d);
    }//Fim setFrontList

    //Função para setar um item no final da lista
    public void setRearList(T data){
        T d = data;
        insertRear(d);
    }//Fim setRearList

    //Função para setar um item em alguma posição da lista
    public void setInPositionList(T data, int position){
        T d = data;
        insertInPosition(d, position);
    }//Fim setInPositionList

    //Insere um item no começo da lista
    private void insertFront(T data){
        Node<T> newNode = new Node<T>(data);

        if(this.tail == null){ //Para o caso da lista estar vazia
            tail = newNode;
            tail.next = newNode;
        }else{ //Para o caso de ter algum item na lista
            newNode.next = tail.next;
            tail.next = newNode;
        }
        ++size;
    }//Fim isert front

    //insere um item no final da lista
    private void insertRear(T data){
        Node<T> newNode = new Node<T>(data);

        if(this.tail == null){ //Para o caso da lista estar vazia
            tail = newNode;
            tail.next = newNode;
        }else{ //Para o caso de ter algum item na lista
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }//Fim insertRear

    //Insere um item uma posição especifica
    private void insertInPosition(T data, int position){
        if((position > this.size) || (position < 1)){
            System.out.printf("Error in insertInPosition, invalid position!!\n\n");
            System.exit(-1);
        }

        if(position == 1){
            insertFront(data);
            return;
        }else{
            Node<T> newNode = new Node<T>(data);
            Node<T> aux = tail.next;

            for(int count = 1; count < position - 1; count++){
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            ++size;
        }
    }//Fim insertInPosition

    //Remove um item da frente da lista
    @Override
    public T removeFront(){
        if(tail == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        Node<T> aux = tail.next;
        T temp = tail.next.data;

        if(aux == tail){
            tail = null;
            aux = null;
            size = 0;
            return temp;
        }else{
            tail.next = aux.next;
            aux = null;
            --size;
            return temp;
        }
    }//Fim removeFront

    //Remove um item do final da lista
    @Override
    public T removeRear(){
        if(tail == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        T temp = tail.data;
        Node<T> aux = tail;

        if(aux == aux.next){
            tail = null;
            aux = null;
            size = 0;
            return temp;
        }else{
            Node<T> nodeTemp = tail.next;

            while(nodeTemp.next != tail){
                nodeTemp = nodeTemp.next;
            }

            nodeTemp.next = aux.next;
            tail = aux.next;
            aux = null;
            --size;
            return temp;
        }
    }//Fim removeRear

    //Remove um item em uma posição especifica na lista
    @Override
    public T removeInPosition(int position){
        if(tail == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        if((position > size) || (position < 1)){
            System.out.printf("Error is removeInPosition, ivalid position!!\n");
            System.exit(-1);
        }

        if(position == 1){
            return removeFront();
        }else if(position == size){
            return removeRear();
        }else{
            Node<T> aux = tail.next;
            Node<T> temp;
            T auxItem;
            
            for(int count = 1; count < position - 1; count++){
                aux = aux.next;
            }

            auxItem = aux.next.data;
            temp = aux.next;
            aux.next = temp.next;
            temp = null;
            --size;
            return auxItem;
        }
    }//Fim removeInPosition

    //Remove um item especifico da lista
    @Override
    public T removeItem(T d){
        Node<T> item = findNode(tail.next, d);
        Node<T> nodeTemp;

        if((getSizeList() == 1) || item.next == tail.next){
            return removeFront();
        }else if(item.next == tail){
            return removeRear();
        }else{
            T temp = item.next.data;
            nodeTemp = item.next;
            item.next = nodeTemp.next;
            nodeTemp = null;
            --size;
            return temp;
        }
    }//Fim removeItem

    //Imprime a lista
    public void printList(){
        if(tail == null){
            System.out.printf("Error in printList, list is empty!!\n\n");
            return;
        }
        printNode(this.tail.next, this.tail.next);
    }//Fim printList

    //Imprime cada nó da lista
    private void printNode(Node<T> h1, Node<T> h2){
        if(h1.next == h2){
            System.out.println(h1.data.toString());
            return;
        }
        System.out.println(h1.data.toString());
        printNode(h1.next, h2);
    }//Fim printNode

    //Procura um nó na lista
    private Node<T> findNode(Node<T> node, T d){
        if(node.next.data.compareTo(d) == 0){
            return node;
        }

        if(node == this.tail){
            System.out.println("Data not found!!\n\n");
            System.exit(-1);
        }

        return findNode(node.next, d);
    }//Fim findNode

    public Node<T> definePrimeiro(Node<T> node, T d){
        if(node.data.compareTo(d) == 0){
            return node;
        }
        return definePrimeiro(node.next, d);
    }

    public Node<T> getTail(){
        return tail;
    }

    public void setTail(Node<T> tail){
        this.tail = tail;
    }
}//Fim classe List