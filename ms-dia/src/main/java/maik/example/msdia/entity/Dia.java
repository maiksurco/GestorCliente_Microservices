package maik.example.msdia.entity;

import jakarta.persistence.*;
import lombok.Data;
import maik.example.msdia.dto.Servicios;

@Entity
@Data
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double pago;
    private String nombre;
    r

}
