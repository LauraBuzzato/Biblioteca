package school.sptech.biblioteca.service;

import org.springframework.stereotype.Service;
import school.sptech.biblioteca.dto.EmprestimoMensagem;
import school.sptech.biblioteca.entity.Cliente;
import school.sptech.biblioteca.entity.Emprestimo;
import school.sptech.biblioteca.entity.Livro;
import school.sptech.biblioteca.repository.ClienteRepository;
import school.sptech.biblioteca.repository.EmprestimoRepository;
import school.sptech.biblioteca.repository.LivroRepository;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    private final LivroRepository livroRepository;
    private final ClienteRepository clienteRepository;
    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoPublisher publisher;

    public EmprestimoService(
            LivroRepository livroRepository,
            ClienteRepository clienteRepository,
            EmprestimoRepository emprestimoRepository,
            EmprestimoPublisher publisher) {

        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.publisher = publisher;
    }

    public Emprestimo emprestar(Integer idLivro, Integer idCliente) {

        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (livro.isEmprestado()) {
            throw new RuntimeException("Livro já está emprestado");
        }

        Emprestimo emprestimo = new Emprestimo(
                livro,
                cliente,
                LocalDate.now()
        );

        livro.setEmprestado(true);

        livroRepository.save(livro);

        Emprestimo emprestimoSalvo =
                emprestimoRepository.save(emprestimo);

        EmprestimoMensagem mensagem = new EmprestimoMensagem(
                emprestimoSalvo.getId(),
                livro.getNome(),
                cliente.getNome(),
                cliente.getEmail(),
                emprestimoSalvo.getDataEmprestimo()
        );

        publisher.enviar(mensagem);

        return emprestimoSalvo;
    }
}
