package maik.example.msfitventas.entity;

import jakarta.persistence.*;
import lombok.Data;
import maik.example.msfitventas.dto.Producto;
import maik.example.msfitventas.dto.Servicios;
import maik.example.msfitventas.dto.Workers;

@Entity
@Data
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    @Transient
    private Producto producto;
    private Integer serviciosId;
    @Transient
    private Servicios servicios;
    private Integer workersId;
    @Transient
    private Workers workers;

    public VentaDetalle(){
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
}
