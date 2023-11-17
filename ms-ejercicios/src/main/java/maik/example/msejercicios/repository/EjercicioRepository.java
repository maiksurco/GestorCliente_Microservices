package maik.example.msejercicios.repository;

import maik.example.msejercicios.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
}
