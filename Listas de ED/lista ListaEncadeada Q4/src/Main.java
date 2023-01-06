import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<String> lista = new List<>();
        Scanner input = new Scanner(System.in);
        System.out.println("digite quantos soldados participarao do sorteio: ");
        int n = input.nextInt();
        String[] nomes = new String[n];
        for(int i= 0 ; i< n; i++){
            System.out.println("insira o nome do "+(i+1)+"º soldado: ");
            nomes[i]=input.next();
            lista.setRearList(nomes[i]);
        }
        
        Random rand = new Random();

        int num = rand.nextInt(6)+1;
        System.out.println("\nEntre com n (> 0): "+num);
        int num2 = rand.nextInt(4);
        System.out.println("\nNome do primeiro sorteado: "+nomes[num2]);
        
        System.out.println("\nNome dos soldados: ");
        for (int i=0; i<lista.getSizeList(); i++){
            System.out.println(nomes[i]);
        }

        System.out.println("--------------------------------\nOrdem de saida: ");

        lista.setTail(lista.definePrimeiro(lista.getTail(), nomes[num2]));

        while(lista.getSizeList() != 1){
            for(int i = 0; i < num-1; i++){
                lista.setTail(lista.getTail().next);
            }
            System.out.printf(lista.removeRear()+" ");

        }

        System.out.println("\nSoldado sorteado: "+lista.getLast());

        input.close();
    }
}
