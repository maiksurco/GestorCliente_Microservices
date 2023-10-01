package com.example.reservas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String servicio;
    private Double cantidad;
    private String estado;
    private Timestamp fechainicio;
    private Timestamp fechafinalizacion;
    private Double costo;

}
