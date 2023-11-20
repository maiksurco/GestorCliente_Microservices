package maik.example.msnotascasillero.service.impl;

import maik.example.msnotascasillero.entity.Casillero;
import maik.example.msnotascasillero.repository.CasilleroRepository;
import maik.example.msnotascasillero.service.CasilleroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasilleroServiceImpl implements CasilleroService {

    @Autowired
    private CasilleroRepository casilleroRepository;

    @Override
    public List<Casillero> listar() {
        return casilleroRepository.findAll();
    }

    @Override
    public Casillero guardar(Casillero casillero) {
        return casilleroRepository.save(casillero);
    }

    @Override
    public Casillero actualizar(Casillero casillero) {
        return casilleroRepository.save(casillero);
    }

    @Override
    public Optional<Casillero> listarPorId(Integer id) {
        return casilleroRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        casilleroRepository.deleteById(id);
    }
}
