package maik.example.msfitventas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    private Integer serviciosId;
    private Integer workersId;

    public VentaDetalle(){
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
}
