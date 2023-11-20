package maik.example.msvisitas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Visitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer diaId;
    @Transient

    private Integer registroId;

}
