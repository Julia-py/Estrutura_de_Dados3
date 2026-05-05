package Arvore;

public class main {
    public static void main(String [] args) {
        Arvore arvore = new Arvore();

        arvore.adicionar(10);
        arvore.adicionar(50);
        arvore.adicionar(5);
        arvore.adicionar(70);
        arvore.adicionar(80);
        arvore.adicionar(45);
        arvore.adicionar(35);
        arvore.adicionar(20);

        System.out.println("Buscar 40: " + arvore.buscar(40));
        System.out.println("Buscar 70: " + arvore.buscar(70));

        arvore.remover(20);
        System.out.println("Buscar 30 após remoção: " + arvore.buscar(30));


        arvore.remover(70);
        System.out.println("Buscar 70 após remoção: " + arvore.buscar(70));

    }
}
