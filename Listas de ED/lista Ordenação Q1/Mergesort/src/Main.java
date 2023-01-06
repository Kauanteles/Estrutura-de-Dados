import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N;
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o tamanho do vetor de pessoas?: ");
            N = input.nextInt();
            Pessoa[] pessoas = new Pessoa[N];
            for(int i=0; i < N; i++){
                Pessoa pessoa = new Pessoa();
                pessoas[i]=pessoa;
                System.out.println("digite a matricula da "+(i+1)+"° pessoa");
                pessoas[i].setMatricula(input.nextInt());
                System.out.println("digite o nome da "+(i+1)+"° pessoa");
                pessoas[i].setNome(input.next());
                System.out.println("digite a nota da "+(i+1)+"° pessoa");
                pessoas[i].setNota(input.nextFloat());
            }

            int resposta;

        do{
            System.out.println("digite o metodo de ordenação a ser usado: (1 para matricula, 2 para nome, 3 para nota, 0 para sair)");
            resposta = input.nextInt();
            switch(resposta){
                case 1:
                System.out.println("\nordenado por matricula: ");
                mergeSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getMatricula());
                }
                break;

                case 2:
                System.out.println("\nordenado alfabeticamente: ");
                mergeSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getNome());
                }
                break;

                case 3:
                System.out.println("\nordenado por nota (decrescente): ");
                mergeSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getNota());
                }
                break;
            }
        }while(resposta != 0);




        input.close();
    }
    public static void mergeSort(Pessoa[] vetor, int chaveOrdenacao){
        int tamanho = vetor.length;

        if(tamanho < 2){
            return;
        }

        int meio = tamanho/2;
        Pessoa[]metadeEsquerda = new Pessoa[meio];
        Pessoa[]metadeDireita = new Pessoa[tamanho - meio];

        for (int i = 0; i < meio; i++){
            metadeEsquerda[i] = vetor[i];
        }

        for (int i = meio; i < tamanho; i++){
            metadeDireita[i-meio] = vetor[i];
        }

        mergeSort(metadeEsquerda, chaveOrdenacao);
        mergeSort(metadeDireita, chaveOrdenacao);

        merge(vetor,metadeEsquerda,metadeDireita, chaveOrdenacao);
    }

    public static void merge(Pessoa[] vetor, Pessoa[] metadeEsquerda, Pessoa[] metadeDireita, int chaveOrdenacao){
        int tamanhoEsquerda = metadeEsquerda.length;
        int tamanhoDireita = metadeDireita.length;

        int i = 0;
        int j = 0;
        int k = 0;

        //fazer pra cada caso dps
        switch (chaveOrdenacao){
            case 1:
            while(i < tamanhoEsquerda && j < tamanhoDireita){
                if (metadeEsquerda[i].getMatricula() <= metadeDireita[j].getMatricula()){
                    vetor[k] = metadeEsquerda[i];
                    i++;
                }else{
                    vetor[k] = metadeDireita[j];
                    j++;
                }
                k++;
            }
            break;

            case 2:
            while(i < tamanhoEsquerda && j < tamanhoDireita){
                if (metadeEsquerda[i].getNome().compareTo(metadeDireita[j].getNome())==-1 || metadeEsquerda[i].getNome().compareTo(metadeDireita[j].getNome())==0){
                    vetor[k] = metadeEsquerda[i];
                    i++;
                }else{
                    vetor[k] = metadeDireita[j];
                    j++;
                }
                k++;
            }
            break;

            case 3:
            while(i < tamanhoEsquerda && j < tamanhoDireita){
                if (metadeEsquerda[i].getNota() >= metadeDireita[j].getNota()){
                    vetor[k] = metadeEsquerda[i];
                    i++;
                }else{
                    vetor[k] = metadeDireita[j];
                    j++;
                }
                k++;
            }
            break;
        }
        while(i < tamanhoEsquerda){
            vetor[k] = metadeEsquerda[i];
            i++;
            k++;
        }
        while(j < tamanhoDireita){
            vetor[k] = metadeDireita[j];
            j++;
            k++;
        }
    }
}
