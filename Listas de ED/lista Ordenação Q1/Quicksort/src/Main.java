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
                Quicksort.QuickSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getMatricula());
                }
                break;

                case 2:
                System.out.println("\nordenado alfabeticamente: ");
                Quicksort.QuickSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getNome());
                }
                break;

                case 3:
                System.out.println("\nordenado por nota (decrescente): ");
                Quicksort.QuickSort(pessoas, resposta);
                for (int i = 0; i < pessoas.length; i++){
                    System.out.println(pessoas[i].getNota());
                }
                break;
            }
        }while(resposta != 0);




        input.close();
    }
}
