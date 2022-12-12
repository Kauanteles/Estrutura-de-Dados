class Main {
  public static void main(String[] args) {
    Cachorro dog1 = new Cachorro(1,"tchonga", false, "pug");
    Fila <Cachorro> fila = new Fila<Cachorro>(dog1);

      fila.enfileira(dog1);
      System.out.println(fila.toString());
  }
}