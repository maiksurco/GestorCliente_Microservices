package com.example.reservas.service;

import com.example.reservas.entity.Asesoramiento;

import java.util.List;
import java.util.Optional;

public interface AsesoramientoService {
    public List<Asesoramiento> listar();
    public Asesoramiento guardar(Asesoramiento asesoramiento);

    public Asesoramiento actualizar(Asesoramiento asesoramiento);

    public Optional<Asesoramiento> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
