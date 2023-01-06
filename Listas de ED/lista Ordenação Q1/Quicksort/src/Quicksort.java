public class Quicksort {
    //metodos
    public static void QuickSort(Pessoa[] vetor, int tipo){
        QuickSort(vetor, 0, vetor.length -1, tipo);
    }
    public static void QuickSort(Pessoa[] vetor, int indiceMin, int indiceMax, int tipo){
        if(indiceMin >= indiceMax){
            return;
        }
        if(tipo == 1){
            Pessoa pivo = vetor[indiceMax];
        int ponteiroEsquerda = indiceMin;
        int ponteiroDireita = indiceMax;

        while(ponteiroEsquerda<ponteiroDireita){
            while(vetor[ponteiroEsquerda].getMatricula()<=pivo.getMatricula() && ponteiroEsquerda < ponteiroDireita){
                ponteiroEsquerda++;
            }
            while(vetor[ponteiroDireita].getMatricula()>= pivo.getMatricula() && ponteiroEsquerda < ponteiroDireita){
                ponteiroDireita--;
            }
            troca(vetor, ponteiroEsquerda, ponteiroDireita);
        }
        troca(vetor, ponteiroEsquerda, indiceMax);
        QuickSort(vetor, indiceMin, indiceMax-1, tipo);
        QuickSort(vetor, ponteiroEsquerda+1, indiceMax, tipo);

        }else if(tipo == 2){

            Pessoa pivo = vetor[indiceMax];
        int ponteiroEsquerda = indiceMin;
        int ponteiroDireita = indiceMax;

        while(ponteiroEsquerda<ponteiroDireita){
            while((vetor[ponteiroEsquerda].getNome().compareTo(pivo.getNome())==-1 || vetor[ponteiroEsquerda].getNome().compareTo(pivo.getNome())==0) && ponteiroEsquerda < ponteiroDireita){
                ponteiroEsquerda++;
            }
            while((vetor[ponteiroDireita].getNome().compareTo( pivo.getNome())==1 || vetor[ponteiroDireita].getNome().compareTo( pivo.getNome())==0) && ponteiroEsquerda < ponteiroDireita){
                ponteiroDireita--;
            }
            troca(vetor, ponteiroEsquerda, ponteiroDireita);
        }
        troca(vetor, ponteiroEsquerda, indiceMax);
        QuickSort(vetor, indiceMin, indiceMax-1, tipo);
        QuickSort(vetor, ponteiroEsquerda+1, indiceMax, tipo);

        }else if(tipo == 3){

            Pessoa pivo = vetor[indiceMax];
            int ponteiroEsquerda = indiceMin;
            int ponteiroDireita = indiceMax;
    
            while(ponteiroEsquerda<ponteiroDireita){
                while(vetor[ponteiroEsquerda].getNota() >= pivo.getNota()  && ponteiroEsquerda < ponteiroDireita){
                    ponteiroEsquerda++;
                }
                while(vetor[ponteiroEsquerda].getNota() <= pivo.getNota()  && ponteiroEsquerda < ponteiroDireita){
                    ponteiroDireita--;
                }
                troca(vetor, ponteiroEsquerda, ponteiroDireita);
            }
            troca(vetor, ponteiroEsquerda, indiceMax);
            QuickSort(vetor, indiceMin, indiceMax-1, tipo);
            QuickSort(vetor, ponteiroEsquerda+1, indiceMax, tipo);
        }
    }

    private static void troca(Pessoa[] vetor, int indice1, int indice2){
        Pessoa temp = vetor[indice1];
        vetor[indice1]=vetor[indice2];
        vetor[indice2]=temp;
    }
}
