package Arvore;

import java.util.Scanner;

public class main {
    public static void main(String [] args) {
        Arvore arvore = new Arvore();
        Scanner sc = new Scanner(System.in);
        int opcao, valor;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Mostrar árvore");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o valor: ");
                    valor = sc.nextInt();
                    arvore.adicionar(valor);
                    break;

                case 2:
                    System.out.print("Digite o valor: ");
                    valor = sc.nextInt();
                    if (arvore.buscar(valor)) {
                        System.out.println("Valor encontrado!");
                    } else {
                        System.out.println("Valor NÃO encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor: ");
                    valor = sc.nextInt();
                    arvore.remover(valor);
                    System.out.println("Valor removido!");
                    break;

                case 4:
                    System.out.println("\n🌳 Árvore:");
                    arvore.imprimir();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}

