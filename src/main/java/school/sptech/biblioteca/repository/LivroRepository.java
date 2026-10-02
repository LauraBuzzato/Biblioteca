package school.sptech.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
