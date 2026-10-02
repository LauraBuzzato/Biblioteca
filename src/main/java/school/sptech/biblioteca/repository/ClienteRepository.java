package school.sptech.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.biblioteca.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}