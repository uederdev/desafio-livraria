package menu;

import dao.AutorDao;
import dao.ClienteDao;
import model.Autor;
import model.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuCliente implements IMenu {

    private final Scanner sc;
    private Integer opcao;

    public MenuCliente(Scanner sc, Integer opcao) {
        this.opcao = opcao;
        this.sc = sc;
    }

    @Override
    public void exibirMenu() {
        opcao = -1;
        System.out.println("--------- Menu Cliente ---------");
        System.out.println("0 - Voltar");
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

    private void findAll() {
        ClienteDao.getInstance().getAll().forEach(System.out::println);
        System.out.println("-------------------------------\n\n");
        close();
    }

    private void findById() {
        sc.nextLine();
        System.out.print("Informe o Id do Cliente: ");
        Long id = sc.nextLong();
        Cliente cliente = ClienteDao.getInstance().getById(id);
        System.out.println(cliente);
        System.out.println("--------------------------------\n\n");
        close();
    }

    private void create() {
        sc.nextLine();
        System.out.print("Informe o nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.print("Informe o e-mail do Cliente: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(nome, email);
        ClienteDao.getInstance().salvar(cliente);

        System.out.println("Autor criado com sucesso!\n");
        close();
    }

    private void edit() {
        sc.nextLine();
        System.out.println("Informe o Id do Cliente: ");
        Long id = sc.nextLong();
        sc.nextLine();

        Cliente clienteEncontrado = ClienteDao.getInstance().getById(id);
        System.out.println("Cliente encontrado: " + clienteEncontrado);
        System.out.println("---------------------------");

        System.out.println("Informe o nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.println("Informe o e-mail do Cliente: ");
        String email = sc.nextLine();
        clienteEncontrado.setNome(nome);
        clienteEncontrado.setEmail(email);

        ClienteDao.getInstance().editar(clienteEncontrado);
        System.out.println("Cliente atualizado com sucesso!\n");
        close();
    }

    private void delete() {
        sc.nextLine();
        System.out.print("Informe o Id do Cliente: ");
        Long id = sc.nextLong();
        ClienteDao.getInstance().excluir(id);
        System.out.println("--------------------------------");
        findAll();
        close();
    }

    public void close() {
        opcao = 0;
    }

}
