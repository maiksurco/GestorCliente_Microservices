package jose.example.msworkers.repository;

import jose.example.msworkers.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepository extends JpaRepository<Workers, Integer> {
}
