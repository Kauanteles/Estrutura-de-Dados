public class NoArvore <T extends Comparable<T>>{
    //Atributos
    private T info;
    private NoArvore<T> pai;
    private NoArvore<T> filhoEsquerdo;
    private NoArvore<T> filhoDireito;

    //Construtor
    public NoArvore(){
    this.info = null;
    this.pai = null;
    this.filhoDireito = null;
    this.filhoEsquerdo = null;
    }

    public NoArvore(T info){
        this();
        this.info = info;
    }

    public int compareTo(T info){
        if(getInfo().compareTo(info) == -1){
            return -1;
        }else if(getInfo().compareTo(info) == 1){
            return 1;
        }else return 0;
    }

    //Getters e Setters
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getPai() {
        return pai;
    }

    public void setPai(NoArvore<T> pai) {
        this.pai = pai;
    }

    public NoArvore<T> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NoArvore<T> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NoArvore<T> getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NoArvore<T> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

}
