package maik.example.msfitventas.repository;

import maik.example.msfitventas.entity.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<VentasEntity,Integer> {
}
