package com.example.reservas.service.impl;

import com.example.reservas.entity.Asesoramiento;
import com.example.reservas.repository.AsesoramientoRepository;
import com.example.reservas.service.AsesoramientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesoramientoServiceImpl implements AsesoramientoService {
    @Autowired
    private AsesoramientoRepository asesoramientoRepository;

    @Override
    public List<Asesoramiento> listar() {
        return asesoramientoRepository.findAll();
    }

    @Override
    public Asesoramiento guardar(Asesoramiento asesoramiento) {
        return asesoramientoRepository.save(asesoramiento);
    }

    @Override
    public Asesoramiento actualizar(Asesoramiento asesoramiento) {
        return asesoramientoRepository.save(asesoramiento);
    }

    @Override
    public Optional<Asesoramiento> listarPorId(Integer id) {
        return asesoramientoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        asesoramientoRepository.deleteById(id);
    }
}
