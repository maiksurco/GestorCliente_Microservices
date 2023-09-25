package elroy.example.msservicios.service.impl;

import elroy.example.msservicios.entity.Servicios;
import elroy.example.msservicios.repository.ServiciosRepository;
import elroy.example.msservicios.service.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiciosServiceImpl implements ServiciosService {
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public List<Servicios> listar() {
        return serviciosRepository.findAll();
    }

    @Override
    public Servicios guardar(Servicios servicios) {
        return serviciosRepository.save(servicios);
    }

    @Override
    public Servicios actualizar(Servicios servicios) {
        return serviciosRepository.save(servicios);
    }

    @Override
    public Optional<Servicios> listarPorId(Integer id) {
        return serviciosRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        serviciosRepository.deleteById(id);
    }
}
