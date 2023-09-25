package maik.example.msprodcat.repository;

import maik.example.msprodcat.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
