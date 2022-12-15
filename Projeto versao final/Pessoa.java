public abstract class Pessoa{
  
    //Atributos
    private String nome;
    private String tel;
    private String cpf;
    private int idade;

    //Construtor
    public Pessoa(String umNome, String umTel , String umCpf , int umaIdade){
      this.nome = umNome;
      this.setTel(umTel);
      if(CpfIsValid(umCpf))
        this.setCpf(umCpf);
      this.idade = umaIdade;
    } 
    public Pessoa(String umNome,String umTel , String umCpf){
      this(umNome, umTel,umCpf, 0);
    }
    public Pessoa(String umNome , String umCpf){
      this(umNome, "(99) 9 9999-9999",umCpf);
    }
    public Pessoa( String umCpf){
      this("Sem Nome",umCpf);
    }
  
    //Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }
  
    public String getTel(){
        return this.tel;
    }
    public String getCpf(){
        return this.cpf;
    }
    
    public void setNome(String umNome){
        this.nome = umNome;
    }
    public void setIdade(int umaIdade){
        this.idade = umaIdade;
    }

    public void setTel(String umTel){
        umTel = umTel.replace("(", "");
        umTel = umTel.replace(")", "");
        umTel = umTel.replace("-", "");
        umTel = umTel.replace(" ", "");
        this.tel = umTel;
    }
    public void setCpf(String umCpf){
        umCpf = umCpf.replace(".", "");
        umCpf = umCpf.replace("-", "");
        umCpf = umCpf.replace(" ", "");
        this.cpf = umCpf;
    }

    //Metodos
    public boolean CpfIsValid(String umCpf){
        umCpf = umCpf.replace("-", "");
        umCpf = umCpf.replace(".", "");
        umCpf = umCpf.replace(" ", "");
        if(umCpf.length() == 11)
          return true;
        return false;
    }

    public String toString(){
      String str = "Nome: " + this.getNome();
      str += ", Idade: " + this.getIdade();
      str += ", Telefone: " + this.getTel();
      str += ", Cpf: " + this.getCpf();
      return str;
    } 
    public int compare(Pessoa umaPessoa){
      int umCpf = Integer.parseInt(umaPessoa.getCpf());
      int thisCpf = Integer.parseInt (this.cpf);
      
      if(umCpf == thisCpf)
        return 0;
      else if(umCpf > thisCpf)
              return -1;
      return 1;
    }
}