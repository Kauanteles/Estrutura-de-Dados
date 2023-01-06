public class insertionSort {
    public insertionSort(){}
    public void insertionSortFunc(Pessoa[] vetor, int tipo) {

        for (int i = 1; i < vetor.length; i++) {
            Pessoa valorAtual = vetor[i];

            int j = i - 1;
            if(tipo == 1){
                while (j >= 0 && vetor[j].getMatricula() > valorAtual.getMatricula()) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
            }else if (tipo == 2){
                while (j >= 0 && vetor[j].getNome().compareTo(valorAtual.getNome())==1) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
            }else if(tipo == 3){
                while (j >= 0 && vetor[j].getNota() < valorAtual.getNota()) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
            }
            vetor[j + 1] = valorAtual;
        }
    }
}
