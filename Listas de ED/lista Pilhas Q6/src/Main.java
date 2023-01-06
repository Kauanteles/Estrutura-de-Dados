import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Pilha<carro> estacionamento = new Pilha<>();
        Pilha<carro> ruaColcic = new Pilha<>();
        Character entrada;
        String placa;
        Scanner input = new Scanner(System.in);

            do{
                System.out.println("digite 'E' para a entrada de um carro no estacionamento ou 'S' para a saida: (caso queira sair digite 'N')");
                entrada = input.next().charAt(0);

                switch (entrada){
                    case 'E':
                    System.out.println("digite a placa do carro que sera estacionado: ");
                    placa = input.next();
                    if (estacionamento.getTamanho()==10){
                        System.out.println("o estacionamento ja esta cheio, favor volte outra hora!"+"\no carro de placa: "+placa+" saiu sem sequer entrar no estacionamento");
                    }else{
                        carro Carro = new carro(placa);
                        estacionamento.push(Carro);
                        System.out.println("o carro de placa "+estacionamento.stacktop().getPlaca()+" chegou!");
                    }
                    break;

                    case 'S':
                    if(estacionamento.getTamanho()==0){
                        System.out.println("o estacionamento esta vazio, nao carro para remover!");
                    }else{
                        Pilha<carro> aux = new Pilha<>();
                        if(estacionamento.getTamanho()==1){
                            aux.push(estacionamento.pop());
                        }else{
                            while(estacionamento.getTamanho() != 1 && estacionamento.getTamanho() != 0){
                                estacionamento.stacktop().VezesManobrado();
                                ruaColcic.push(estacionamento.pop());
                                if(estacionamento.getTamanho()==1){
                                    aux.push(estacionamento.pop());
                                }
                            }
                            while(ruaColcic.getTamanho()!=0){
                                estacionamento.push(ruaColcic.pop());
                            }
                        }
                        System.out.println("o carro de placa "+aux.stacktop().getPlaca()+" saiu, sendo manobrado para outros estacionarem: "+aux.stacktop().getVezesManobrado()+" vezes");
                    }
                    break;
                }

            }while(entrada!='N');
            input.close();















    }
}
