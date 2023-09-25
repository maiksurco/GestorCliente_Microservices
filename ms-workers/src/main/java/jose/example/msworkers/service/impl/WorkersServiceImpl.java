package jose.example.msworkers.service.impl;

import jose.example.msworkers.entity.Workers;
import jose.example.msworkers.repository.WorkersRepository;
import jose.example.msworkers.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkersServiceImpl implements  WorkersService{
    @Autowired
    private WorkersRepository workersRepository;

    @Override
    public List<Workers> listar() {
        return workersRepository.findAll();
    }

    @Override
    public Workers guardar(Workers workers) {
        return workersRepository.save(workers);
    }

    @Override
    public Workers actualizar(Workers workers) {
        return workersRepository.save(workers);
    }

    @Override
    public Optional<Workers> listarPorId(Integer id) {
        return workersRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        workersRepository.deleteById(id);
    }
}
