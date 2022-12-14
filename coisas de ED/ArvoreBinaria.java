public class ArvoreBinaria<T extends Comparable<T>> {
    private NoArvore<T> raiz;
    private int tamanho = 0;

    public ArvoreBinaria() {
        raiz = null;
    }

    public ArvoreBinaria(T info) {
        insereNaArvore(info);
    }

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

    public void imprimeArvore(){
        imprimeNoArvore(getRaiz());
    }

    private void imprimeNoArvore(NoArvore<T> raiz){
        if(raiz != null){
            imprimeNoArvore(raiz.getFilhoEsquerdo());
            System.out.println(raiz.getInfo().toString());
            imprimeNoArvore(raiz.getFilhoDireito());
        }
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
