package menu;

import dao.AutorDao;
import dao.LivroDao;
import model.Autor;
import model.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuLivro implements IMenu{

    private final Scanner sc;
    private Integer opcao;

    public MenuLivro(Scanner sc, Integer opcao) {
        this.opcao = opcao;
        this.sc = sc;
    }

    @Override
    public void exibirMenu() {
        opcao = -1;
        System.out.println("--------- Menu Livro ---------");
        System.out.println("0 - Sair do Sistema");
        System.out.println("--------- -------------- ---------");
        System.out.println("1 - Criar ");
        System.out.println("2 - Modificar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar Todos");
        System.out.println("5 - Listar Por Id");
        System.out.println("--------- -------------- ---------");

        while (opcao != 0) {
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    close();
                    break;
                case 1:
                    create();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    findAll();
                    break;
                case 5:
                    findById();
                    break;
                default:
                    System.out.println("Opção selecionada é inválida.\n\n\n");
                    break;
            }
        }
    }

    private void create() {
        System.out.println("---------------------------------");
        System.out.println("Lista de Autores:");
        AutorDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("---------------------------------");

        sc.nextLine();
        System.out.println("Informe o titulo do Livro: ");
        String nome = sc.nextLine();

        System.out.println("Informe o Id do Autor: ");
        Long idAutor = sc.nextLong();
        Autor autor = AutorDao.getInstance().getById(idAutor);

        var livro = new Livro();
        livro.setTitulo(nome);
        livro.setAutor(autor);

        LivroDao.getInstance().salvar(livro);
        System.out.println("Livro criado com sucesso!");
        close();
    }

    private void edit(){
        sc.nextLine();
        System.out.print("Informe o Id do Livro: ");
        Long id = sc.nextLong();
        Livro livroEncontrado = LivroDao.getInstance().getById(id);

        sc.nextLine();
        System.out.print("Informe o titulo do Livro: ");
        String nome = sc.nextLine();

        System.out.print("Informe o Id do Autor: ");
        Long idAutor = sc.nextLong();
        Autor autor = AutorDao.getInstance().getById(idAutor);

        livroEncontrado.setTitulo(nome);
        livroEncontrado.setAutor(autor);


        LivroDao.getInstance().editar(livroEncontrado);
        System.out.println("Livro criado com sucesso!");

        close();
    }

    private void delete(){
        sc.nextLine();
        System.out.print("Informe o Id do Livro: ");
        Long id = sc.nextLong();
        LivroDao.getInstance().excluir(id);
        System.out.println("--------------------------------");
        findAll();
    }

    private void findById() {
        sc.nextLine();
        System.out.print("Informe o Id do Livro: ");
        Long id = sc.nextLong();
        Livro livro = LivroDao.getInstance().getById(id);
        System.out.println(livro);
        System.out.println("--------------------------------");
    }

    private void findAll() {
        LivroDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("-------------------------------\n\n");
        close();
    }

    private void close() {
        opcao = 0;
    }

}
