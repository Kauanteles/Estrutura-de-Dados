public abstract class AnimalAbstrato {
    //Atributos
    private int idade;
    private String nome;
    private boolean casoGrave;

    //Construtor
    AnimalAbstrato(int umaIdade, String umNome, boolean umCasoGrave){
      this.idade = umaIdade;
      this.nome = umNome;
      this.casoGrave = umCasoGrave;
    }
    AnimalAbstrato(String umNome, boolean casoGrave){
      this(0, umNome, casoGrave);
    }
    AnimalAbstrato(boolean casoGrave){
      this("Sem Nome", casoGrave);
    }
    AnimalAbstrato(){
      this(0,null,false);
    }
  
    //Getters e Setters
    public String getNome(){
        return this.nome;
    }
    public int getIdade(){
        return this.idade;
    }
    public boolean getCasoGrave(){
        return this.casoGrave;
    }

    public void setNome(String umNome){
        this.nome = umNome;
    }
    public void setIdade(int umaIdade){
        this.idade = umaIdade;
    }
    public void setCasoGrave(boolean umCasoGrave){
        this.casoGrave = umCasoGrave;
    }
  
    //Metodos
    public String toString(){
      String str = "Nome: " + this.getNome();
      str += "Idade: " + this.getIdade();
      str += "Caso Grave: " + this.getCasoGrave();
      return str;
    }
}