package com.example.msfacturas.dto;

import lombok.Data;

@Data
public class Producto {
    private Integer id;
    private String nombre;
    private String precio;
    private String detalle;
    private Categoria categoria;
}
