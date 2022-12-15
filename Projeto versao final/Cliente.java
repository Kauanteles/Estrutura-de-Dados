public class Cliente extends Pessoa implements ICliente , Comparable<Cliente>{
  public static int quantidade=0;
  private boolean casoGrave;

  ListaEncadeada<Animal> pets = new ListaEncadeada<Animal>();

  //Construtor
  Cliente(String umNome, String umTel , String umCpf , int umaIdade,boolean caso){
    super(umNome, umTel, umCpf, umaIdade);
    this.casoGrave = caso;
    quantidade++;
  }
  Cliente(String umNome,String umTel , String umCpf, boolean caso){
      this(umNome, umTel, umCpf,0, caso);
  }
  Cliente(String umNome, String umCpf,boolean caso){
      this(umNome,"(00)0000-0000", umCpf, caso);
  }
  Cliente(){
      this("sem nome","000.000.000-00",false);
  }

  //Getters e Setters
  public boolean getCasoGrave(){
      return this.casoGrave;
  }
  public void setCasoGrave(boolean umCasoGrave){
      this.casoGrave = umCasoGrave;
  }
  
  //Metodos
  public static String toQuantidade(){
    return "Quantidade: "+ quantidade;
  }
  public String toString(){
      return "\nCliente: \nCaso Grave: "+this.getCasoGrave() + ", " + super.toString();
  } 
  
  public int compareTo(Cliente umCliente){
      int umCpf = Integer.parseInt (umCliente.getCpf());
      int thisCpf = Integer.parseInt(this.getCpf());
      
      if(umCpf == thisCpf)
        return 0;
      else if(umCpf > thisCpf)
             return -1;
      return 1;
    }
}