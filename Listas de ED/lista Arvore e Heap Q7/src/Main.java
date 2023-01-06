import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("digite o tamanho do vetor que deseja heapificar: ");
        int vetor[] = new int[input.nextInt()];
        System.out.println("digite o tipo de heap que deseja: (1 para minheap e 2 para maxheap)");
        int tipo = input.nextInt();

        for(int i = 0; i < vetor.length; i ++){
            System.out.println("digite o valor para o elemento "+i+" do vetor");
            vetor[i]=input.nextInt();
        }
        
        System.out.println("\no vetor apos a heapficação ficou: ");

        Heap h = new Heap(vetor, vetor.length, tipo);

        while(h.getTamanhoVet()>0){
            System.out.printf(h.removeRaiz(h.tipo)+", ");
        }
        input.close();
    }
}

class Heap{
    int vetor[];
    int tamanhoVet;
    int tipo;

    public Heap(int vetor[], int tamanhoVet, int tipo){
        this.vetor = vetor;
        this.tamanhoVet = tamanhoVet;
        this.tipo = tipo;

        this.constroiHeap();
    }

    void constroiHeap(){
        for(int i= this.tamanhoVet/2-1; i>=0; i--){
            heapify(i,tipo);
        }
    }

    void heapify(int indiceRaiz, int tipo){
        int filho = indiceRaiz*2+1;

        if(tipo==2){
            int indiceMaximo = indiceRaiz;
            if(filho<this.tamanhoVet){
                if(vetor[filho] > vetor[indiceRaiz]){
                    indiceMaximo = filho;
                }
            }
            if(filho+1<this.tamanhoVet){
                if(vetor[filho+1] > vetor[indiceMaximo]){
                    indiceMaximo = filho+1;
                }
            }
    
            troca(vetor, indiceRaiz, indiceMaximo);
            if(indiceRaiz!=indiceMaximo){
                heapify(indiceMaximo,tipo);
            }
        }else if(tipo == 1){
            int indiceMinimo = indiceRaiz;
            if(filho<this.tamanhoVet){
                if(vetor[filho] < vetor[indiceRaiz]){
                    indiceMinimo = filho;
                }
            }
            if(filho+1<this.tamanhoVet){
                if(vetor[filho+1] < vetor[indiceMinimo]){
                    indiceMinimo = filho+1;
                }
            }
    
            troca(vetor, indiceRaiz, indiceMinimo);
            if(indiceRaiz!=indiceMinimo){
                heapify(indiceMinimo,tipo);
            }
        }
    }

    void troca(int vetor[], int indice1, int indice2){
        int temp = vetor[indice1];
        vetor[indice1] = vetor[indice2];
        vetor[indice2] = temp;
    }

    int removeRaiz(int tipo){
        if(tipo==2){
            int max = vetor[0];
            vetor[0] = vetor[--tamanhoVet];
            heapify(0,tipo);
        return max;
        }else{
            int min = vetor[0];
            vetor[0] = vetor[--tamanhoVet];
            heapify(0,tipo);
            return min;
        }
    }

    int getTamanhoVet(){
        return tamanhoVet;
    }
}