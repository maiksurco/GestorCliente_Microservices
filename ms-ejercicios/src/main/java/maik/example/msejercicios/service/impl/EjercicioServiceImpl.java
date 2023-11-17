package maik.example.msejercicios.service.impl;

import maik.example.msejercicios.entity.Ejercicio;
import maik.example.msejercicios.repository.EjercicioRepository;
import maik.example.msejercicios.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EjercicioServiceImpl implements EjercicioService {
    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public List<Ejercicio> listar() {
        return ejercicioRepository.findAll();
    }

    @Override
    public Ejercicio guardar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public Ejercicio actualizar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public Optional<Ejercicio> listarPorId(Integer id) {
        return ejercicioRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ejercicioRepository.deleteById(id);

    }
}
