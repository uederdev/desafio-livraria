package dao;

import model.Autor;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDados {

    private static BancoDados instance;
    private static List<Autor> autores = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();
    private static Long id;

    private BancoDados(){
        var autor1 = new Autor(getId(), "Machado de Assis", LocalDate.of(1957, 10, 10));
        var autor2 = new Autor(getId(), "Carlos Drumond de Andrade", LocalDate.of(1922,12,31));
        var autor3 = new Autor(getId(), "Clarice Lispector", LocalDate.of(1933,5,21));

        autores.addAll(List.of(autor1, autor2, autor3));

        var cliente1 = new Cliente("Zezim", "zezim@mail.com");
        cliente1.setId(getId());

        var cliente2 = new Cliente("Joaozim", "joazim@mail.com");
        cliente2.setId(getId());

        var cliente3 = new Cliente("Mane", "mane@mail.com");
        cliente3.setId(getId());

        clientes.addAll(List.of(cliente1, cliente2, cliente3));

        var livro1 = new Livro(getId(), "O cortiço", autor1);
        var livro2 = new Livro(getId(), "A morte de Wolverine", autor2);
        var livro3 = new Livro(getId(), "Batman vs Superman", autor3);

        livros.addAll(List.of(livro1, livro2, livro3));

        var e1 = new Emprestimo(livro1, cliente3);
        var e2 = new Emprestimo(livro2, cliente2);
        var e3 = new Emprestimo(livro3, cliente1);
        emprestimos.addAll(List.of(e1, e2, e3));
    }

    public static BancoDados getInstance(){
        if (instance == null){
            instance = new BancoDados();
        }
        return instance;
    }

    public List<Autor> getAutores(){
        return autores;
    }

    public List<Livro> getLivros(){
        return livros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public Long getId() {
        return Math.round(Math.random() * 1000);
    }
}
