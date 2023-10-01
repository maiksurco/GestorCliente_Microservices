package com.example.reservas.service.impl;

import com.example.reservas.entity.Reserva;
import com.example.reservas.repository.ReservaRepository;
import com.example.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva actualizar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Optional<Reserva> listarPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        reservaRepository.deleteById(id);
    }
}