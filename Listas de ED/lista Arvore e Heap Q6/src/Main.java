public class Main {
    public static void main(String[] args){
        ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
        arvore1.insereNaArvore(1);
        arvore1.insereEsquerda(arvore1.getRaiz(), 2);
        arvore1.insereDireita(arvore1.getRaiz(), 3);

        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
        arvore2.insereNaArvore(3);
        arvore2.insereEsquerda(arvore2.getRaiz(), 2);
        arvore2.insereDireita(arvore2.getRaiz(), 1);

        ArvoreBinaria<Integer> arvore3 = new ArvoreBinaria<>();
        arvore3.insereNaArvore(4);
        arvore3.insereEsquerda(arvore3.getRaiz(), 1);
        arvore3.insereDireita(arvore3.getRaiz(), 5);

        if(ehHeap(arvore1.getRaiz())==1){
            System.out.println("a primeira arvore é um max heap");
        }else if (ehHeap(arvore1.getRaiz())==-1){
            System.out.println("a primeira arvore é um min heap");
        }else System.out.println("a primeira arvore nao é um heap");

        if(ehHeap(arvore2.getRaiz())==1){
            System.out.println("a segunda arvore é um max heap");
        }else if (ehHeap(arvore2.getRaiz())==-1){
            System.out.println("a segunda arvore é um min heap");
        }else System.out.println("a segunda arvore nao é um heap");

        if(ehHeap(arvore3.getRaiz())==1){
            System.out.println("a terceira arvore é um max heap");
        }else if (ehHeap(arvore3.getRaiz())==-1){
            System.out.println("a terceira arvore é um min heap");
        }else System.out.println("a terceira arvore nao é um heap");
    }


    private static int quantidadeNos(NoArvore<Integer> raiz)
    {
        if (raiz == null) {
            return 0;
        }
        return 1 + quantidadeNos(raiz.getFilhoEsquerdo()) + quantidadeNos(raiz.getFilhoDireito());
    }
 
    private static boolean ehMinHeap(NoArvore<Integer> raiz, int i, int n)
    {

        if (raiz == null) {
            return true;
        }
 
        if (i >= n) {
            return false;
        }
 
        if ((raiz.getFilhoEsquerdo() != null && raiz.getFilhoEsquerdo().getInfo() <= raiz.getInfo()) ||
                    (raiz.getFilhoDireito() != null && raiz.getFilhoDireito().getInfo() <= raiz.getInfo())) {
            return false;
        }
 
        return ehMinHeap(raiz.getFilhoEsquerdo(), 2*i + 1, n) &&
            ehMinHeap(raiz.getFilhoDireito(), 2*i + 2, n);
    }
 
    public static boolean ehMinHeap(NoArvore<Integer> raiz)
    {
        int i = 0;
        return ehMinHeap(raiz, i, quantidadeNos(raiz));
    }

    //max

    private static boolean ehMaxHeap(NoArvore<Integer> raiz, int i, int n)
    {

        if (raiz == null) {
            return true;
        }
 
        if (i >= n) {
            return false;
        }
 
        if ((raiz.getFilhoEsquerdo() != null && raiz.getFilhoEsquerdo().getInfo() >= raiz.getInfo()) ||
                    (raiz.getFilhoDireito() != null && raiz.getFilhoDireito().getInfo() >= raiz.getInfo())) {
            return false;
        }
 
        return ehMaxHeap(raiz.getFilhoEsquerdo(), 2*i + 1, n) &&
            ehMaxHeap(raiz.getFilhoDireito(), 2*i + 2, n);
    }
 
    public static boolean ehMaxHeap(NoArvore<Integer> raiz)
    {
        int i = 0;
        return ehMaxHeap(raiz, i, quantidadeNos(raiz));
    }

    public static int ehHeap(NoArvore<Integer> raiz){
        if(ehMaxHeap(raiz)){
            return 1;
        }else if (ehMinHeap(raiz)){
            return -1;
        }else return 0;
    }
}
