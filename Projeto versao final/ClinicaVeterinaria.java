import java.util.Scanner;
import java.io.*;

public class ClinicaVeterinaria{
    //criando fila de atendimento
    Fila<Cliente> filaDeAtendimento = new Fila<Cliente>();
    //criando arvore de clientes
    ArvoreBinaria<Cliente> arvoreDeCliente = new ArvoreBinaria<Cliente>();
    //criando lista de veterinario
    ListaEncadeada<Veterinario> listaDeVeterinario = new ListaEncadeada<Veterinario>();
  
    public int menuPrincipal(){
      //Imprime na tela as opções
      System.out.printf("\nSEJA BEM VINDO(A) !!\n\n");
      System.out.printf("[0] Para listar CPFs dos funcioarios\n");
      System.out.printf("[1] Para ver as opções de funcioarios\n");
      System.out.printf("[2] Para ver as oções de clientes\n");
      System.out.printf("[3] Para encerrar o programa\n");
      System.out.printf("Escolha uma opção: ");

      Scanner input = new Scanner(System.in);
      int escolha = input.nextInt();

      //Switch para escolher o qual opção será executada
      switch(escolha){
          case 0:
              //cria vetor de int com os cpfs dos veterinarios, ordena e imprime.
              return 1;
          case 1:
              System.out.printf("\nveterinario");opcoesDeFuncionarios();
              return 1;
          case 2:
              System.out.printf("\n cliente\n");opcoesDeClientes();
              return 1;
          case 3:
              System.out.printf("Encerrando...\n\n");
              return -1;
          default:
              System.out.printf("Erro, opção invalida!!\n\n");
              return 1;
      }//Fim switch
  }//Fim menu
 
  
//===========================================funções para funcionarios================================== 
  // mostra as opçoes de funcionario
  public void opcoesDeFuncionarios(){
    //Imprime na tela as opções
    System.out.printf("\n[1] Para adicionar um novo veterinário\n");
    System.out.printf("[2] Para remover um veterinário\n");
    System.out.printf("[3] Para modificar um veterinário\n");
    System.out.printf("[4] Para mostrar todos os veterinários\n");
    System.out.printf("Escolha uma opção: ");
    Scanner input = new Scanner(System.in);
    int escolha = input.nextInt();
    do{
      //Switch para escolher o qual opção será executada
      switch(escolha){
          case 1:
              addVeterinario();
              break;
          case 2:
              remVeterinario();
              break;
          case 3:
              modificaVeterinario();
              break;
          case 4:
              mostraVeterinarios();
              break;
          default:
              System.out.printf("Erro, opção invalida!!\n\n");
              break;
      }//Fim switch
    }while(escolha<1||escolha>4);
  }
  //recebe informações de um veterinario e retorna um obj da classe veterinario
  public Veterinario criaVeterinario(){
    Scanner std = new Scanner(System.in);
    System.out.printf("\nDigite os dados do veterinario\n");
    System.out.printf("\nDigite o nome: ");
    String nome = std.nextLine();
    System.out.printf("\nDigite o telefone: ");
    String tel = std.nextLine();
    System.out.printf("\nDigite o CPF: ");
    String cpf = std.nextLine();
    System.out.printf("Digite a idade: ");
    int idade = std.nextInt();
    Veterinario novo = new Veterinario(nome,tel,cpf,idade);
    return novo;
  }
  //recebe um veterinario e adiciona a lista de veterinarios
  public void addVeterinario(){
    Veterinario novo = new Veterinario();
    novo= criaVeterinario();
    listaDeVeterinario.adicionarInicio(novo);
    System.out.printf(novo.getNome()+" foi adicionado!\n");
  }
  public void remVeterinario(){
    Scanner std = new Scanner(System.in);
    System.out.printf("\ndigite o cpf do veterinário: \n");
    String cpf = std.nextLine();
    Veterinario novo = new Veterinario("sem nome",cpf);
    if(listaDeVeterinario.remocaoSucedida(novo) == true){
      Veterinario.dimQuantidade();
      System.out.printf("\nremovido com sucesso!!\n");
    }
    else
      System.out.printf("\nerro, falha ao remover!!\n");
  }
  public void modificaVeterinario(){
    Scanner std = new Scanner(System.in);
    System.out.printf("\ndigite o cpf do veterinário: \n");
    String cpf = std.nextLine();
    Veterinario novo = new Veterinario("sem nome",cpf);
    if(listaDeVeterinario.remocaoSucedida(novo)){
      System.out.printf("\nDê as novas informações do Veterinário:\n");
      novo = criaVeterinario();
      listaDeVeterinario.adicionarInicio(novo);
    }
    else 
        System.out.printf("\nerro ao modificar veterinario!\n");  
  }
  public void mostraVeterinarios(){
    System.out.printf("\nVeterinarios:\n" + listaDeVeterinario.toString());
  }


//===========================================funções para clientes======================================
  //Mostra opções de cliente
  public void opcoesDeClientes(){
    //Imprime na tela as opções
    System.out.printf("\n[1] Para adicionar um novo Cliente a fila de atendimento\n");
    System.out.printf("[2] Para adicionar um cliente a fila de atedimento\n");
    System.out.printf("[3] Para remover um cliente dá fila de atendimento\n");
    System.out.printf("[4] Para mostrar todos os clientes\n");
    System.out.printf("Escolha uma opção: ");
    Scanner input = new Scanner(System.in);
    int escolha = input.nextInt();
    do{
      //Switch para escolher o qual opção será executada
      switch(escolha){
          case 1:
              addNovoCliente();
              break;
          case 2:
              addCliente();
              break;
          case 3:
              remCliente();
              break;
          case 4:
              mostraClientes();
              break;
          default:
              System.out.printf("Erro, opção invalida!!\n\n");
              break;
      }//Fim switch
    }while(escolha<1||escolha>3);
  }

  //cria um cliente
  public Cliente criaCliente(){
    //Imprime na tela as opções
    Scanner std = new Scanner(System.in);
    boolean casoGrave;
    System.out.printf("\nDigite os dados do cliente\n");
    System.out.printf("\nDigite o nome: ");
    String nome = std.nextLine();
    System.out.printf("\nDigite o telefone: ");
    String tel = std.nextLine();
    System.out.printf("\nDigite o CPF: ");
    String cpf = std.nextLine();
    System.out.printf("Digite a idade: ");
    int idade = std.nextInt();
    System.out.printf("Digte o caso (v para grave e f para nao grave): ");
    String caso = std.nextLine();
    if(caso == "f")
      casoGrave = false;
    else casoGrave = true;
    Cliente novo =  new Cliente(nome,tel,cpf,idade,casoGrave);
    int escolha;
    do{
      System.out.printf("\nolá, "+novo.getNome()+". aperte 1 para adicione um animal ou 2 para sair: \n");
      Scanner input = new Scanner(System.in);
      escolha = input.nextInt();
      switch(escolha){
        case 1:
          System.out.printf("\nDigite o nome: ");
          nome = std.nextLine();
          System.out.printf("\nDigite a especie: ");
          String especie = std.nextLine();
          System.out.printf("Digite a idade: ");
          idade = std.nextInt();
          Animal a1 = new Animal(idade,nome,especie,novo.getCpf());
          novo.pets.adicionarInicio(a1);
          System.out.printf("\nadicionado.\n");
          break;
        case 2: 
          System.out.printf("saindo...\n");
        default: 
          System.out.printf("Erro, opção invalida!!\n\n");
          break;
      }
    }while(escolha!=2);
    return novo;
  } 
  
  //adiciona um novo cliente a fila
  public void addNovoCliente(){
    Cliente novo= new Cliente();
    novo = criaCliente();
    if(novo.getCasoGrave()== true)
      filaDeAtendimento.adicionarInicio(novo);
    filaDeAtendimento.enfileira(novo);
  }
  
  //adiciona um cliente ja existente a fila
  public void addCliente(){
    Scanner std = new Scanner(System.in);
    System.out.printf("\ndigite o cpf do cliente: \n");
    String cpf = std.nextLine();
    Cliente novo = new Cliente("sem nome",cpf,false);
    NoArvore<Cliente> aux = new NoArvore<Cliente>();
    aux = arvoreDeCliente.buscaNaArvore(novo,arvoreDeCliente.getRaiz());
    if(aux==null)
      System.out.printf("\nerro,cliente nao encontrado!!\n");
    else{
      if(aux.getInfo().getCasoGrave())
        filaDeAtendimento.adicionarInicio(novo);
      filaDeAtendimento.enfileira(novo);
    }
      
  }

  //remove um cliente da fila de atendimento
  public void remCliente(){
      filaDeAtendimento.desenfileira();
  }

  //imprime os clientes
  public void mostraClientes(){
    System.out.printf("\nClientes:\n" + arvoreDeCliente.toString());
  }
}
