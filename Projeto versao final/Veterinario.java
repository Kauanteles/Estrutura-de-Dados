public class Veterinario extends Pessoa implements IVeterinario{
  public static int quantidade=0;
  //Construtor
  Veterinario(String umNome, String umTel , String umCpf , int umaIdade){
    super(umNome, umTel, umCpf, umaIdade);
    quantidade++;
  }
  Veterinario(String umNome,String umTel , String umCpf){
      super(umNome, umTel, umCpf);
      quantidade++;
  }
  Veterinario(String umNome, String umCpf){
      super(umNome, umCpf);
      quantidade++;
  }
  Veterinario(){
      super("sem nome", "000.000.000-00");
      quantidade++;
  }

  //Metodos
  public static void dimQuantidade(){
     quantidade--;
  }
  public static String toQuantidade(){
    return "Quantidade: "+ quantidade;
  }
  public String toString(){
      return "\nVeterinario:\n" + super.toString();
  } 
  
  public int compareTo(Veterinario umVet){
      int umCpf = Integer.parseInt(umVet.getCpf());
      int thisCpf = Integer.parseInt(this.getCpf());
      
      if(umCpf == thisCpf)
        return 0;
      else if(umCpf > thisCpf)
             return -1;
      return 1;
  }
}
  