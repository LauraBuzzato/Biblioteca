package school.sptech.biblioteca.controller;

import org.springframework.web.bind.annotation.*;
import school.sptech.biblioteca.entity.Emprestimo;
import school.sptech.biblioteca.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping("/livro/{idLivro}/cliente/{idCliente}")
    public Emprestimo emprestar(
            @PathVariable Integer idLivro,
            @PathVariable Integer idCliente) {

        return service.emprestar(idLivro, idCliente);
    }
}
