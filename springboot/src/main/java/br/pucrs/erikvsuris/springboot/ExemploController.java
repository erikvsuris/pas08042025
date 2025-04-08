package br.pucrs.erikvsuris.springboot;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private List<Livro> livros;

    public ExemploController() {
        livros = new ArrayList<>();
        livros.add(new Livro(1, "Arte da Guerra", 2000, "Sun Tzu"));
        livros.add(new Livro(2, "Tratado de Economia Doméstica", 2019, "Aristóteles"));
        livros.add(new Livro(3, "Apologia de Socrates", 2014, "Platão"));
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livros;
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        List<String> titulos = new ArrayList<>();
        for (Livro livro : livros) {
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }

    @GetMapping("/anos")
    public List<Integer> getAnos() {
        List<Integer> anos = new ArrayList<>();
        for (Livro livro : livros) {
            anos.add(livro.getAno());
        }
        return anos;
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        for (Livro livro : livros) {
            autores.add(livro.getAutor());
        }
        return autores;
    }

}