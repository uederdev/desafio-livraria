package menu;

import dao.AutorDao;
import model.Autor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuAutor implements IMenu {

    private final Scanner sc;
    private Integer opcao;

    public MenuAutor(Scanner sc, Integer opcao) {
        this.sc = sc;
        this.opcao = opcao;
    }

    @Override
    public void exibirMenu() {
        opcao = -1;
        System.out.println("--------- Menu Autor ---------");
        System.out.println("0 - Sair do Sistema");
        System.out.println("--------- -------------- ---------");
        System.out.println("1 - Criar ");
        System.out.println("2 - Modificar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar Todos");
        System.out.println("5 - Listar Por Id");
        System.out.println("--------- -------------- ---------");
        while (opcao != 0) {
            System.out.print("Informe a opção desejada: ");
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

    private void findById() {
        sc.nextLine();
        System.out.print("Informe o Id do Autor: ");
        Long id = sc.nextLong();
        Autor autor = AutorDao.getInstance().getById(id);
        System.out.println(autor);
        System.out.println("--------------------------------\n\n");
        close();
    }

    private void findAll() {
        AutorDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("-------------------------------\n\n");
        close();
    }

    private void create() {
        sc.nextLine();
        System.out.print("Informe o nome do Autor: ");
        String nome = sc.nextLine();

        System.out.print("Informe a data de nascimento do Autor: ");
        String dataNascimento = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lDataNascimento = LocalDate.parse(dataNascimento, formatter);

        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setDataNascimento(lDataNascimento);

        AutorDao.getInstance().salvar(autor);
        System.out.println("Autor criado com sucesso!\n");
        close();
    }

    private void delete(){
        sc.nextLine();
        System.out.print("Informe o Id do Autor: ");
        Long id = sc.nextLong();
        AutorDao.getInstance().excluir(id);
        System.out.println("--------------------------------");
        findAll();
        close();
    }

    private void edit(){
        sc.nextLine();
        System.out.println("Informe o Id do Autor: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Autor autorEncontrado = AutorDao.getInstance().getById(id);
        System.out.println("Autor encontrado: " + autorEncontrado);
        System.out.println("---------------------------");

        System.out.println("Informe o nome do Autor: ");
        String nome = sc.nextLine();

        System.out.println("Informe a data de nascimento do Autor: (dd/MM/yyyy)");
        String dataNascimento = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lDataNascimento = LocalDate.parse(dataNascimento, formatter);

        Autor autor = new Autor(id, nome, lDataNascimento);
        AutorDao.getInstance().editar(autor);
        System.out.println("Autor atualizado com sucesso!\n");
        close();
    }

    private void close(){
        opcao = 0;
    }
}
