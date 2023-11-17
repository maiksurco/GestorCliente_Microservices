package maik.example.msnotascasillero.repository;

import maik.example.msnotascasillero.entity.Casillero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasilleroRepository extends JpaRepository<Casillero, Integer> {
}
