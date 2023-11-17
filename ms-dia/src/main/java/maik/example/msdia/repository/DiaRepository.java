package maik.example.msdia.repository;

import maik.example.msdia.entity.Dia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaRepository extends JpaRepository<Dia, Integer> {
}
