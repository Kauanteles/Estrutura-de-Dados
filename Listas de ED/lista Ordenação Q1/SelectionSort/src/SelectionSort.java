public class SelectionSort {

    public static void selectionSort(Pessoa[] vetor, int tipo) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if(tipo == 1){
                    if (vetor[minimo].getMatricula() > vetor[j].getMatricula()) {
                        minimo = j;
                    }
                }else if(tipo == 2){
                    if (vetor[minimo].getNome().compareTo(vetor[j].getNome())==1) {
                        minimo = j;
                    }
                }else if(tipo == 3){
                    if (vetor[minimo].getNota() < vetor[j].getNota()) {
                        minimo = j;
                    }
                }
                
            }
            Pessoa temp = vetor[i];
            vetor[i] = vetor[minimo];
            vetor[minimo] = temp;
        }
    }
}
