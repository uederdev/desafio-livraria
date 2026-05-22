import menu.MenuPrincipal;

import java.util.Scanner;

public class Main {

    private static int opcao = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuPrincipal.exibir();
        System.out.print("Informe a opção desejada: ");
        opcao = sc.nextInt();
        MenuPrincipal.opcaoSelecionada(opcao);
    }

}
