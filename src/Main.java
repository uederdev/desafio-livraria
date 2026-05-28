import menu.*;

import java.util.Scanner;

public class Main {

    private static Integer opcao = -1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (opcao != 0) {
            new MenuPrincipal().exibirMenu();
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
                case 3:
                    MenuCliente menuCliente = new MenuCliente(sc, opcao);
                    menuCliente.exibirMenu();
                    opcao = -1;
                    break;
                case 4:
                    MenuEmprestimos menuEmprestimos = new MenuEmprestimos(sc, opcao);
                    menuEmprestimos.exibirMenu();
                    opcao = -1;
                    break;
                default:
                    System.out.println("Opção selecionada é inválida.\n\n\n");
                    break;
            }
        }
    }

}
