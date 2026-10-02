package school.sptech.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.biblioteca.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}