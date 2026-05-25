package menu;

public class MenuPrincipal implements IMenu {

    @Override
    public void exibirMenu() {
        System.out.println("--------- Menu Principal ---------");
        System.out.println("0 - Sair do Sistema");
        System.out.println("--------- -------------- ---------");
        System.out.println("1 - Autor");
        System.out.println("2 - Livro");
        System.out.println("3 - Emprestar Livros");
        System.out.println("--------- -------------- ---------");
        System.out.println("4 - Livros da Biblioteca");
        System.out.println("--------- -------------- ---------\n");
    }
}
