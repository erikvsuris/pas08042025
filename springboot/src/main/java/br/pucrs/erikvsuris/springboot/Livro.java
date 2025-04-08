package br.pucrs.erikvsuris.springboot;

public class Livro {
    private int id;
    private String titulo;
    private int ano;
    private String autor;

    public Livro(int id, String titulo, int ano, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

}