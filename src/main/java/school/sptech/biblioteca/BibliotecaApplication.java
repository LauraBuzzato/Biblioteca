package school.sptech.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import school.sptech.biblioteca.entity.Cliente;
import school.sptech.biblioteca.entity.Livro;
import school.sptech.biblioteca.repository.ClienteRepository;
import school.sptech.biblioteca.repository.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Bean
	CommandLineRunner carregarDadosDeDemonstracao(
			ClienteRepository clientes,
			LivroRepository livros) {
		return args -> {
			if (clientes.count() == 0) {
				clientes.save(new Cliente("Maria Silva", "maria@example.com"));
			}
			if (livros.count() == 0) {
				livros.save(new Livro("Dom Casmurro", "Machado de Assis", 256));
			}
		};
	}
}
