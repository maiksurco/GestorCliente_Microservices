package maik.example.msnotascasillero.repository;

import maik.example.msnotascasillero.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
