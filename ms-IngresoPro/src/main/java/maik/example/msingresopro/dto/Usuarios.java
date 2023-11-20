package maik.example.msingresopro.dto;

import lombok.Data;


@Data
public class Usuarios {
    private Integer id;
    private String nombre;
    private String apellidoPater;
    private String rol;
    private String Clave;
    private String claveConfirma;
    private String Foto;

}
