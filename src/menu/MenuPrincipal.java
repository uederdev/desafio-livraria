package menu;

import dao.AutorDao;
import model.Autor;

public class MenuPrincipal {

    public static void exibir(){
        System.out.println("--------- Menu Principal ---------");
        System.out.println("0 - Sair do Sistema");
        System.out.println("--------- -------------- ---------");
        System.out.println("1 - Criar Autor");
        System.out.println("2 - Criar Livro");
        System.out.println("3 - Emprestar Livros");
        System.out.println("--------- -------------- ---------");
        System.out.println("4 - Livros da Biblioteca");
        System.out.println("--------- -------------- ---------");

    }

    public static void opcaoSelecionada(int opcao) {
        switch (opcao) {
            case 0:
                System.out.println("--------- -------------- ---------");
                System.out.println("Saindo do Sistema...");
                System.out.println("--------- -------------- ---------");
                System.exit(0);
                break;
            case 1:
                Autor autor = AutorDao.getInstance().buscarPorId(2l);
                System.out.println(autor);
                break;
            case 2:
                System.out.println("Criando Livro...");
                break;
            case 3:
                break;
                default:
                    System.out.println("Opção Inválida...\n\n");
                    exibir();
                    break;

        }
    }
}
