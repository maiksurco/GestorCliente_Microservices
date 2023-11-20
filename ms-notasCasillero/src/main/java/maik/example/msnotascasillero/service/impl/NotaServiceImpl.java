package maik.example.msnotascasillero.service.impl;

import maik.example.msnotascasillero.entity.Nota;
import maik.example.msnotascasillero.repository.NotaRepository;
import maik.example.msnotascasillero.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Override
    public List<Nota> listar() {
        return notaRepository.findAll();
    }

    @Override
    public Nota guardar(Nota nota) {
        return notaRepository.save(nota);
    }

    @Override
    public Nota actualizar(Nota nota) {
        return notaRepository.save(nota);
    }

    @Override
    public Optional<Nota> listarPorId(Integer id) {
        return notaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        notaRepository.deleteById(id);
    }
}
