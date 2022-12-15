public class Animal extends AnimalAbstrato{
  //Atributos
  public static int quantidade=0;
  private String especie;
  private String cpfDoResponsavel;
  private boolean tratamento= false;

  //contrutor
  Animal( int umaIdade, String umNome, String umaEspecie, String umCpf){
    super(umaIdade, umNome);
    this.especie= umaEspecie;
    if(CpfIsValid(umCpf))
        this.setCpfResponsavel(umCpf);
    else {
      System.out.println("cpf inválido!");
      this.setCpfResponsavel("00000000000");
    }
    quantidade++;
  }
  Animal(String umNome, String umaEspecie, String umCpf){
      this(0, umNome, umaEspecie, umCpf);
  }
  Animal( String umaEspecie, String umCpf){
    this("Sem Nome", umaEspecie, umCpf);
  }
  Animal( String umCpf){
      this("sem especie", umCpf);
  }
  Animal(){
    this("000.000.000-00");
  }

  //Setters e Getters
  public void setCpfResponsavel(String umCpf){
      umCpf = umCpf.replace(".", "");
      umCpf = umCpf.replace("-", "");
      umCpf = umCpf.replace(" ", "");
      this.cpfDoResponsavel = umCpf;
  }
  public void setTratamento(boolean tratamento){
      this.tratamento= tratamento;
  }
  public void setEspecie(String umaEspecie){
    this.especie= umaEspecie;
  }
  public String getCpfResponsavel(){
      return this.cpfDoResponsavel;
  }
  public boolean getTratamento(){
    return this.tratamento;
  }
  public String getEspecie(){
    return this.especie;
  }
  //Metodos
  public static String toQuantidade(){
    return "Quantidade: "+ quantidade;
  }
  // Válida cpf
  public boolean CpfIsValid(String umCpf){
        umCpf = umCpf.replace(".", "");
        umCpf = umCpf.replace("-", "");
        umCpf = umCpf.replace(" ", "");
        if(umCpf.length() == 11)
          return true;
        return false;
  }
  //retorna string com informações do animal
  public String toString(){
    String str = super.toString();
    str += ", Especie: " + this.getEspecie();
    str += ", Cpf Do Responsavel: " + this.getCpfResponsavel();
    str += ", Tratamento: " + this.getTratamento();
    return str;
  }
}
