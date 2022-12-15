public abstract class AnimalAbstrato {
    //Atributos
    private int idade;
    private String nome;

    //Construtor
    AnimalAbstrato(int umaIdade, String umNome){
      this.idade = umaIdade;
      this.nome = umNome;
    }
    AnimalAbstrato(String umNome){
      this(0, umNome);
    }
    AnimalAbstrato(){
      this("Sem Nome");
    }
  
    //Getters e Setters
    public String getNome(){
        return this.nome;
    }
    public int getIdade(){
        return this.idade;
    }

    public void setNome(String umNome){
        this.nome = umNome;
    }
    public void setIdade(int umaIdade){
        this.idade = umaIdade;
    }
  
    //Metodos
    //retorna string com informações do animal
    public String toString(){
      String str = "\nAnimal:\nNome: " + this.getNome();
      str += ", Idade: " + this.getIdade();
      return str;
    }
}