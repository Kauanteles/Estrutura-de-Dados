public class Main <T extends Comparable<T>>{
    public static void main(String[] args) {
        CAVALO cavalo1 = new CAVALO("bob",2);
        CAVALO cavalo2 = new CAVALO("bobo",3);
        CAVALO cavalo3 = new CAVALO("pog",4);

        ArvoreBinaria<CAVALO> arvore = new ArvoreBinaria<CAVALO>(cavalo1);
        arvore.insereNaArvore(cavalo2);
        arvore.insereNaArvore(cavalo3);

        arvore.imprimeArvore();
    }
}
