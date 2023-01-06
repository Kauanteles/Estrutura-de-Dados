import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Fila<Integer> fila = new Fila<>();
        Scanner input = new Scanner(System.in);

        //Justificativa: escolhi a fila por ser o nome da lista de exercicio, mesmo que ultilizando-a resulte nos numeros sairem ao contrario

        System.out.println("digite o numero a ser fatorado: ");
        int n = input.nextInt();

        fila = fatoraPrimo(n);
        for (int i=fila.getTamanho(); i!=0; i--){
            System.out.printf(fila.desenfileira()+" * ");
        }

        input.close();
    }

    public static Fila<Integer> fatoraPrimo(int n){
        Fila<Integer> fila = new Fila<>();

        while(n % 2 == 0){
            fila.enfileira(2);
            n = n/2;
        }

        int aux = 3;
        while(aux * aux <= n){
            if(n % aux == 0){
                fila.enfileira(aux);
                n = n/aux;
            }else {
                aux = aux + 2;
            }
        }
        if(n > 1){
            fila.enfileira(n);
        }
        return fila;
    }
}
