package jose.example.msworkers.service;

import jose.example.msworkers.entity.Workers;

import java.util.List;
import java.util.Optional;
public interface WorkersService {
    public List<Workers> listar();

    public Workers guardar(Workers workers);

    public Workers actualizar(Workers workers);

    public Optional<Workers> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
