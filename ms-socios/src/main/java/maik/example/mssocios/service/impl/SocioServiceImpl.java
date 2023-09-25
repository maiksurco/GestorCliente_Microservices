package maik.example.mssocios.service.impl;

import maik.example.mssocios.entity.Socio;
import maik.example.mssocios.repository.SocioRepository;
import maik.example.mssocios.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioServiceImpl implements SocioService {
    @Autowired
    private SocioRepository socioRepository;

    @Override
    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    @Override
    public Socio guardar(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public Socio actualizar(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public Optional<Socio> listarPorId(Integer id) {
        return socioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        socioRepository.deleteById(id);
    }
}
