package model;

import java.time.LocalDate;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private Boolean disponivel;
    private LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataAlteracao;

    public Livro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void disponivel() {
        this.disponivel = true;
        this.dataAlteracao = LocalDate.now();
    }

    public void emprestado(){
        this.disponivel = false;
        this.dataAlteracao = LocalDate.now();
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }


}
