package com.example.reservas.service;

import com.example.reservas.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    public List<Reserva> listar();

    public Reserva guardar(Reserva reserva);

    public Reserva actualizar(Reserva reserva);

    public Optional<Reserva> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}