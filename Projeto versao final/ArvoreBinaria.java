public class ArvoreBinaria<T extends Comparable<T>> {
    //Atributos
    private NoArvore<T> raiz;
    private int tamanho = 0;

    //Construtores
    public ArvoreBinaria() {
        raiz = null;
    }

    public ArvoreBinaria(T info) {
        insereNaArvore(info);
    }

    //Metodos
    // função que insere um novo nó na arvore em seu lugar correto
    public void insereNaArvore(T info) {
        if (raiz == null) {
            NoArvore<T> novoNoArvore = new NoArvore<T>(info);
            raiz = novoNoArvore;
        } else {
            if (info.compareTo(raiz.getInfo()) == -1) {
                insereEsquerda(raiz, info);
            } else {
                if (info.compareTo(raiz.getInfo()) == 1) {
                    insereDireita(raiz, info);
                }
            }
        }
        tamanho++;
    }

    // funções de inserção a esquerda e direita de um dado nó da arvore
    private void insereEsquerda(NoArvore<T> No, T info) {
        if (No.getFilhoEsquerdo() == null) {
            NoArvore<T> novoNoArvore = new NoArvore<T>(info);
            novoNoArvore.setInfo(info);
            No.setFilhoEsquerdo(novoNoArvore);
            novoNoArvore.setPai(No);
            return;
        } else {
            if (info.compareTo(No.getFilhoEsquerdo().getInfo()) == -1) {
                insereEsquerda(No.getFilhoEsquerdo(), info);
            } else if (info.compareTo(No.getFilhoEsquerdo().getInfo()) == 1) {
                insereDireita(No.getFilhoEsquerdo(), info);
            }
        }
    }

    //insere um novo nó de arvore à direita do nó passado como parametro
    private void insereDireita(NoArvore<T> No, T info) {
        if (No.getFilhoDireito() == null) {
            NoArvore<T> novoNoArvore = new NoArvore<T>(info);
            novoNoArvore.setInfo(info);
            No.setFilhoDireito(novoNoArvore);
            novoNoArvore.setPai(No);
            return;
        } else {
            if (info.compareTo(No.getFilhoDireito().getInfo()) == -1) {
                insereEsquerda(No.getFilhoDireito(), info);
            } else if (info.compareTo(No.getFilhoDireito().getInfo()) == 1) {
                insereDireita(No.getFilhoDireito(), info);
            }
        }
    }

    //imprime a arvore binaria em ordem crescente
    public void imprimeArvore(){
        imprimeNoArvore(getRaiz());
    }

    //classe complementar necessaria para imprimir a arvore
    private void imprimeNoArvore(NoArvore<T> raiz){
        if(raiz != null){
            imprimeNoArvore(raiz.getFilhoEsquerdo());
            System.out.println(raiz.getInfo().toString());
            imprimeNoArvore(raiz.getFilhoDireito());
        }
    }

    //realiza a busca do elemento passado como paramentro dentro da arvore a partir de um dado no raiz
    public NoArvore<T> buscaNaArvore(T info, NoArvore<T> No){
        if(No.getFilhoDireito() == null &&No.getFilhoEsquerdo() == null){
            return No = null;
        }
        if(No.compareTo(info) == 0){
            return No;
        }else if(No.compareTo(info) == -1){
            return buscaNaArvore(info,No.getFilhoEsquerdo());
        }else return buscaNaArvore(info, No.getFilhoDireito());
    }

    //Getters e Setters
    
    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
