package com.example.reservas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Asesoramiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombrec;
    private Timestamp fecha;
    private String asesor;
    private String area;
    private String descripcion;
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Reserva reserva;

}