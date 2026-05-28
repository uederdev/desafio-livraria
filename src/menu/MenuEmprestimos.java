package menu;

import dao.ClienteDao;
import dao.EmprestimoDao;
import dao.LivroDao;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class MenuEmprestimos implements IMenu {

    private final Scanner sc;
    private Integer opcao;

    public MenuEmprestimos(Scanner sc, Integer opcao) {
        this.opcao = opcao;
        this.sc = sc;
    }

    @Override
    public void exibirMenu() {
        opcao = -1;
        System.out.println("--------- Menu Emprestimos ---------");
        System.out.println("0 - Voltar");
        System.out.println("--------- -------------- ---------");
        System.out.println("1 - Emprestar Livro");
        System.out.println("2 - Livros disponíveis");
        System.out.println("3 - Livros emprestados - Por Cliente");
        System.out.println("4 - Livros emprestados");
        System.out.println("--------- -------------- ---------");

        while (opcao != 0) {

            System.out.print("Informe a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    close();
                    break;
                case 1:
                    createEmprestimos();
                    break;
                case 2:
                    findByDisponiveis();
                    break;
                case 3:
                    findByEmprestadosByCliente();
                    break;
                case 4:
                    findByEmprestados();
                    break;
                default:
                    System.out.println("Opção selecionada é inválida.\n\n\n");
                    break;
            }
        }
    }

    private void createEmprestimos() {
        System.out.println("------------------------");
        System.out.println("Livros disponíveis");
        System.out.println("------------------------");
        findByDisponiveis();
        System.out.println("------------------------");
        sc.nextLine();
        System.out.print("Informe o Id do Livro: ");
        Long idLivro = sc.nextLong();
        Livro livro = LivroDao.getInstance().getById(idLivro);

        System.out.println("------------------------");
        System.out.println("Clientes");
        System.out.println("------------------------");
        ClienteDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("------------------------");
        System.out.print("Informe o Id do Cliente: ");
        Long idCliente = sc.nextLong();
        Cliente cliente = ClienteDao.getInstance().getById(idCliente);

        Emprestimo emprestimo = new Emprestimo(livro, cliente);
        EmprestimoDao.getInstance().create(emprestimo);
        System.out.println("Livro emprestado com sucesso!");
        close();
    }

    private void findByEmprestadosByCliente() {
        sc.nextLine();
        System.out.println("------------------------");
        System.out.println("Clientes");
        System.out.println("------------------------");
        ClienteDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("------------------------");
        System.out.print("Informe o Id do Cliente: ");
        long clienteId = sc.nextLong();
        System.out.println("------------------------");
        EmprestimoDao.getInstance().getAllByCliente(clienteId).forEach(System.out::println);
        System.out.println("------------------------");
    }

    private void findByEmprestados() {
        List<Livro> livros = LivroDao.getInstance().getAllByStatus(false);
        if (livros.isEmpty()) {
            System.err.println("Não existem livros emprestados!\n\n");
        } else {
            livros.forEach(System.out::println);
        }
        close();
    }

    private void findByDisponiveis() {
        List<Livro> livros = LivroDao.getInstance().getAllByStatus(true);
        if (livros.isEmpty()) {
            System.err.println("Todos os livros estão emprestados!\n\n");
        } else {
            livros.forEach(System.out::println);
        }
        close();
    }

    private void close() {
        opcao = 0;
    }
}
