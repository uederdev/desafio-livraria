package model;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private Livro livro;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void emprestar() {
        this.dataEmprestimo = LocalDate.now();
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
    }
}
