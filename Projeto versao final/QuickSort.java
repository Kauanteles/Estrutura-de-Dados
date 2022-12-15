public class QuickSort{

    //metodos
    public static void quicksort(int[] vetor, int indiceMin, int indiceMax){
        if(indiceMin >= indiceMax){
            return;
        }
        int pivo = vetor[indiceMax];
        int ponteiroEsquerda = indiceMin;
        int ponteiroDireita = indiceMax;

        while(ponteiroEsquerda<ponteiroDireita){
            while(vetor[ponteiroEsquerda]<=pivo && ponteiroEsquerda < ponteiroDireita){
                ponteiroEsquerda++;
            }
            while(vetor[ponteiroDireita]>= pivo && ponteiroEsquerda < ponteiroDireita){
                ponteiroDireita--;
            }
            troca(vetor, ponteiroEsquerda, ponteiroDireita);
        }
        troca(vetor, ponteiroEsquerda, indiceMax);
        quicksort(vetor, indiceMin, indiceMax-1);
        quicksort(vetor, ponteiroEsquerda-1, indiceMax);
    }

    private static void troca(int[] vetor, int indice1, int indice2){
        int temp = vetor[indice1];
        vetor[indice1]=vetor[indice2];
        vetor[indice2]=temp;
    }
}