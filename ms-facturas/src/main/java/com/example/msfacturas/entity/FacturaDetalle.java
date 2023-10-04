package com.example.msfacturas.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.example.msfacturas.dto.Producto;
import com.example.msfacturas.dto.Servicios;
import com.example.msfacturas.dto.Workers;

@Entity
@Data
public class FacturaDetalle {
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

    public FacturaDetalle(){
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
}
