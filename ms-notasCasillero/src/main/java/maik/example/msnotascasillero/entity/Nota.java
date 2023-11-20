package maik.example.msnotascasillero.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Data
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Date Fecha;
    private Integer registroId;
    @Transient
    private Registro registro;
}
