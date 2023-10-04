package com.example.msfacturas.service;

import com.example.msfacturas.entity.FacturasEntity;

import java.util.List;
import java.util.Optional;

public interface FacturasService {
    public List<FacturasEntity> listar();

    public FacturasEntity guardar(FacturasEntity ventasEntity);

    public FacturasEntity actualizar(FacturasEntity ventasEntity);

    public Optional<FacturasEntity> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
