public class CAVALO implements Comparable<CAVALO>{
    public String nome;
    public int idade;

    public CAVALO(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public int compareTo(CAVALO horse){
        if (horse.idade == this.idade){
            return 0;
        }else return 1;
    }

    public String toString(){
        return "\nidade: "+idade+"\nnome: "+nome;
    }
}
