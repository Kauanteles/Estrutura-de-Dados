public class Main {
    public static void main(String[] args) throws Exception {
        
        String expressao1 = "{[(5 × 7)/5] × 4 - [(5 × 7) × 2]} /(3 × 6)";
        String expressao2 = "{2 + [(16 + 2 ∧ 3) - 4)} × 3";

        Pilha<Character> abreParentesis = new Pilha<>();
        Pilha<Character> abreCouchete = new Pilha<>();
        Pilha<Character> abreChaves = new Pilha<>();
        Pilha<Character> fechaParentesis = new Pilha<>();
        Pilha<Character> fechaCouchete = new Pilha<>();
        Pilha<Character> fechaChaves = new Pilha<>();

        for(int i=0; i<expressao1.length(); i++){ 

            switch(expressao1.charAt(i)){
                case '{':
                abreChaves.push(expressao1.charAt(i));
                break;

                case '[':
                abreCouchete.push(expressao1.charAt(i));
                break;

                case '(':
                abreParentesis.push(expressao1.charAt(i));
                break;

                case '}':
                fechaChaves.push(expressao1.charAt(i));
                break;

                case ']':
                fechaCouchete.push(expressao1.charAt(i));
                break;

                case ')':
                fechaParentesis.push(expressao1.charAt(i));
                break;
            }
        }

        if(abreChaves.getTamanho()==fechaChaves.getTamanho() && abreCouchete.getTamanho()==fechaCouchete.getTamanho() && abreParentesis.getTamanho()==fechaParentesis.getTamanho()){
            System.out.println("a expressão 1 é valida!\n");
        }else System.out.println("a expressão 1 é invalida!\n");

        for(int i=abreChaves.getTamanho();i!=0;i--){
            abreChaves.pop();
        } 
        for(int i=fechaChaves.getTamanho();i!=0;i--){
            fechaChaves.pop();
        } 
        for(int i=abreCouchete.getTamanho();i!=0;i--){
            abreCouchete.pop();
        } 
        for(int i=fechaCouchete.getTamanho();i!=0;i--){
            fechaCouchete.pop();
        } 
        for(int i=abreParentesis.getTamanho();i!=0;i--){
            abreParentesis.pop();
        } 
        for(int i=fechaParentesis.getTamanho();i!=0;i--){
            fechaParentesis.pop();
        } 
         
        
        
        for(int i=0; i<expressao2.length(); i++){ 

            switch(expressao2.charAt(i)){
                case '{':
                abreChaves.push(expressao2.charAt(i));
                break;

                case '[':
                abreCouchete.push(expressao2.charAt(i));
                break;

                case '(':
                abreParentesis.push(expressao2.charAt(i));
                break;

                case '}':
                fechaChaves.push(expressao2.charAt(i));
                break;

                case ']':
                fechaCouchete.push(expressao2.charAt(i));
                break;

                case ')':
                fechaParentesis.push(expressao2.charAt(i));
                break;
            }
        }

        if(abreChaves.getTamanho()==fechaChaves.getTamanho() && abreCouchete.getTamanho()==fechaCouchete.getTamanho() && abreParentesis.getTamanho()==fechaParentesis.getTamanho()){
            System.out.println("a expressão 2 é valida!\n");
        }else System.out.println("a expressão 2 é invalida!\n"); 

    }
}