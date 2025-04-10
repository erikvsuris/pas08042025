package br.pucrs.erikvsuris.springboot;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Query String
    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livros.stream()
            .filter(livro->livro.getAutor().equals(autor))
            .toList();
    }

    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public List<Livro> getMethodName(@PathVariable(value = "autor") String autor,
                                @PathVariable(value = "ano") int ano) {
        return livros.stream()
            .filter(livro->livro.getAutor().equals(autor))
            .filter(livro->livro.getAno() == ano)
            .toList();
    }
    

    @PostMapping("/novolivro")
    public boolean addLivro(@RequestBody final Livro novoLivro) {
        return livros.add(novoLivro);
    }

    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Livro> getLivroTitulo(@PathVariable("titulo") String titulo) {
        Livro resp = livros.stream()
            .filter(livro->livro.getTitulo().equals(titulo))
            .findFirst()
            .orElse(null);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(resp);
    }

/* 
 * Path parameters:
    3. Crie um endpoint para /livrosautorano/{autor}/ano/{ano} que trate um ‘path parameters’.
    4. No Postman crie uma requisição para testar este endpoint com /livrosautorano/Pedro da
    Silva/ano/2024
    • Body data:
    5. Crie um endpoint para /novolivro que trate um ‘body data’.
    6. No Postman crie uma requisição POST para testar este endpoint com os dados em JSON:
    {
    "id":"160",
    "titulo":"Postman",
    "autor":"Joana Moura",
    "ano": "2024"
    }
    7. Depois de executar, execute novamente o teste de /biblioteca/livros, para ver se o livro foi
    inserido.
    • Response Entity:
    8. Crie um endpoint para /livrotitulo/{titulo} que retorna uma ‘ResponseEntity’.
    9. No Postman crie uma requisição para testar este endpoint com /livrotitulo/Aprendendo
    Java
 */

}