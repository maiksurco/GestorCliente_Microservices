package com.rooster.msinv.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rooster.msinv.entity.Inventario;
import com.rooster.msinv.service.InventarioService;
@Service

public class InventarioServiceImpl  implements InventarioService {
    @Override
    public List<Inventario> listar() {
        return null;
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return null;
    }

    @Override
    public Inventario actualizar(Inventario inventario) {
        return null;
    }

    @Override
    public Optional<Inventario> listarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void eliminarPorId(Integer id) {

    }
}
