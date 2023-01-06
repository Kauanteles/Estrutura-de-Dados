import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String palavra;
        
        System.out.println("digite a palavra a ser analisada: ");
        palavra = input.next();

        System.out.println("a função ehPalindromoIterativo retornou: "+ehPalindromoIterativo(palavra));

        System.out.println("a função ehPalindromoRecursivo retornou: "+ehPalindromoRecursivo(palavra));
        input.close();
    }


    
    public static boolean ehPalindromoRecursivo(String palavra){
        ListaEncadeada<Character> lista = new ListaEncadeada<>();

        for (int i = 0; i<palavra.length(); i++){
            lista.setFinal(palavra.charAt(i));
        }
        return stringToLista(lista);
    }

    public static boolean ehPalindromoIterativo(String palavra){

        ListaEncadeada<Character> lista = new ListaEncadeada<>();

        for (int i = 0; i<palavra.length(); i++){
            lista.setFinal(palavra.charAt(i));
        }

        int meio;
        int cont = 0;

        if(lista.getTamanho()==0 || lista.getTamanho()==1){
            return false;
        }else {
            if(lista.getTamanho()%2==0){
                meio = (lista.getTamanho()/2);
                for(int i=0; i <= meio-1; i++){
                    if(lista.removeInicio()==lista.removeFinal()){
                        cont++;
                    }else {
                        return false;
                    }
                }
                if (cont == meio){
                    return true;
                }else {
                    return false;
                }
            }else {
                meio = (lista.getTamanho()/2) + 1;
                for(int i=0; i < meio-1; i++){
                    if(lista.removeInicio()==lista.removeFinal()){
                        cont++;
                    }else {
                        return false;
                    }
                }
                if (cont == meio-1){
                    return true;
                }else {
                    return false;
                }
            }
        }
    }



    private static boolean stringToLista(ListaEncadeada<Character> lista){

        if (lista.getTamanho()==0 || lista.getTamanho()==1){
            return false;
        }
        
        if (lista.getTamanho()==3 || lista.getTamanho()==2){
            if (lista.removeInicio()==lista.removeFinal()){
                return true;
            }else{
                return false;
            }
        }else {
            if (lista.removeInicio()==lista.removeFinal()){
                if (lista.getTamanho()==0){
                    return true;
                }
                return stringToLista(lista);
            }else return false; 
        }

    }

}
