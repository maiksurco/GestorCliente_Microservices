package maik.example.msingresopro.entity;

import jakarta.persistence.*;
import lombok.Data;
import maik.example.msingresopro.dto.Usuarios;

import java.util.Date;

@Entity
@Data
public class IngresosProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numFactura;
    private Date fecha;
    private String proveedor;
    private String metPago;
    private Integer usuariosId;
    @Transient
    private Usuarios usuarios;

}
