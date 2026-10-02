package school.sptech.biblioteca.controller;

import org.springframework.web.bind.annotation.*;
import school.sptech.biblioteca.entity.Livro;
import school.sptech.biblioteca.repository.LivroRepository;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }
}
