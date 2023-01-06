import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
    
        String[] cartas = new String[]{"pausA","paus2","paus3","paus4","paus5","paus6","paus7","paus8","paus9","paus10","pausJ","pausQ","pausK",
                                       "ourosA","ouros2","ouros3","ouros4","ouros5","ouros6","ouros7","ouros8","ouros9","ouros10","ourosJ","ourosQ","ourosK",
                                       "copasA","copas2","copas3","copas4","copas5","copas6","copas7","copas8","copas9","copas10","copasJ","copasQ","copasK",
                                       "espadasA","espadas2","espadas3","espadas4","espadas5","espadas6","espadas7","espadas8","espadas9","espadas10","espadasJ","espadasQ","espadasK"};
        
        Pilha<String> pilha1 = new Pilha<String>();
        Pilha<String> pilha2 = new Pilha<String>();
        Pilha<String> pilha3 = new Pilha<String>();
        Pilha<String> pilha4 = new Pilha<String>();
        Random rand = new Random();

        System.out.println("cartas antes do embaralhamento: "+ Arrays.toString(cartas));
        

        while(pilha1.getTamanho()!=25){
            pilha1.push(cartas[rand.nextInt(52)]);
        }

        while(pilha2.getTamanho()!=17){
            pilha2.push(cartas[rand.nextInt(52)]);
        }

        while(pilha3.getTamanho()!=10){
            pilha3.push(cartas[rand.nextInt(52)]);
        }

        System.out.println("\npilha1: "+pilha1.toString());
        System.out.println("\npilha2: "+pilha2.toString());
        System.out.println("\npilha3: "+pilha3.toString());

        while(pilha4.getTamanho()!=52){
            int dice = rand.nextInt(3);
            switch(dice){
                case 0:
                if(pilha1.getTamanho()==0){
                    dice=1;
                }else pilha4.push(pilha1.pop());

                case 1:
                if(pilha2.getTamanho()==0){
                    dice=2;
                }else pilha4.push(pilha2.pop());

                case 2:
                if(pilha3.getTamanho()==0){
                    dice=0;
                }else pilha4.push(pilha3.pop());
            }
        }

        System.out.println("\npilha4: "+pilha4.toString());
    }
}
