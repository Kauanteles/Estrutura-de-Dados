public class Cachorro extends AnimalAbstrato{
    private String pedigree;
    
    public Cachorro(){
        super();
        pedigree = null;
    }

    public Cachorro(int idade,String nome,boolean caso, String pedigree){
        super(idade,nome,caso);
        this.pedigree = pedigree;
    }

    public void makeSound(){
        System.out.println("auauauauauauauauauauauauau "+pedigree);
    }
}
