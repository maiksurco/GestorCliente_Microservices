package maik.example.msnutricion.service.impl;

import maik.example.msnutricion.entity.Nutricion;
import maik.example.msnutricion.repository.NutricionRepository;
import maik.example.msnutricion.service.NutricionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionServiceImpl implements NutricionService {

    @Autowired
    private NutricionRepository nutricionRepository;

    @Override
    public List<Nutricion> listar() {
        return nutricionRepository.findAll();
    }

    @Override
    public Nutricion guardar(Nutricion nutricion) {
        return nutricionRepository.save(nutricion);
    }

    @Override
    public Nutricion actualizar(Nutricion nutricion) {
        return nutricionRepository.save(nutricion);
    }

    @Override
    public Optional<Nutricion> listarPorId(Integer id) {
        return nutricionRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        nutricionRepository.deleteById(id);
    }
}
