package maik.example.msfitventas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import maik.example.msfitventas.dto.Socio;

import java.util.List;
import java.util.Date;
@Entity
@Data
public class VentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serie;
    private String fecha;
    private String descripcion;
    private String metPago;
    private String estado;
    private String proDes;
    private Double total;
    private Integer socioId;
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<VentaDetalle> Detalles;
    @Transient
    private Socio socio;
}
