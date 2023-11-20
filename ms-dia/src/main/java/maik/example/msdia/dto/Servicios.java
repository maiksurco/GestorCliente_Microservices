package maik.example.msdia.dto;

import lombok.Data;


@Data
public class Servicios {
    private Integer id;
    private String nombre;
    private Double precio;
    private String duracion;
    private String disponibilidad;
    private String descripcion;

}
