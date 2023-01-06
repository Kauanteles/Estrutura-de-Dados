import java.util.Random;

public class Main {
    public static void main(String[] args){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        Random rand = new Random();

        System.out.println("elementos da arvore analisada: ");
        for (int i = 0; i < 3; i ++){
            int aux = rand.nextInt(7);
            System.out.println(aux);
            arvore.insereNaArvore(aux);
        }

        System.out.println("\ntamanho da arvore acima = "+altura(arvore.getRaiz()));
    }

    public static int altura(NoArvore<Integer> Node){
        if (Node == null){
            return 0;
        }
        int alturaEsquerda = altura(Node.getFilhoEsquerdo());
        int alturaDireita = altura(Node.getFilhoDireito());

        if (alturaEsquerda>alturaDireita){
            return alturaEsquerda + 1;
        }else{
            return alturaDireita + 1;
        }
    }

}
