package maik.example.msnotascasillero.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Casillero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private String disponibilidad;
    private Date fecha;
    private String comentarios;
    private Integer registroId;
    @Transient
    private Registro registro;
}
