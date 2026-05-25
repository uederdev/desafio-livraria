import menu.MenuAutor;
import menu.MenuLivro;
import menu.MenuPrincipal;

import java.util.Scanner;

public class Main {

    private static Integer opcao = -1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (opcao != 0) {
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.exibirMenu();

            System.out.print("Informe a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do Sistema...");
                    System.exit(0);
                case 1:
                    MenuAutor menuAutor = new MenuAutor(sc, opcao);
                    menuAutor.exibirMenu();
                    opcao = -1;
                    break;
                case 2:
                    MenuLivro menuLivro = new MenuLivro(sc, opcao);
                    menuLivro.exibirMenu();
                    opcao = -1;
                    break;
                default:
                    System.out.println("Opção selecionada é inválida.\n\n\n");
                    break;
            }
        }
    }

}
