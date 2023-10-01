package com.rooster.msinv.service;

import com.rooster.msinv.entity.Inventario;
import java.util.List;
import java.util.Optional;

public interface InventarioService {
    public List<Inventario> listar();

    public Inventario guardar(Inventario categoria);

    public Inventario actualizar(Inventario categoria);

    public Optional<Inventario> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
