package model;

import java.time.LocalDate;

public class Livro {

    private Long id;
    private String titulo;
    private Autor autor;
    private Boolean disponivel = true;
    private LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataAlteracao;

    public Livro() {

    }

    public Livro(Long id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
