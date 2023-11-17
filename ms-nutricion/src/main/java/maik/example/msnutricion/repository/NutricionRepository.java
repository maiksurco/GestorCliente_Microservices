package maik.example.msnutricion.repository;

import maik.example.msnutricion.entity.Nutricion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutricionRepository extends JpaRepository<Nutricion, Integer> {
}
