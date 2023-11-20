package maik.example.msdia.service;

import maik.example.msdia.entity.Dia;

import java.util.List;
import java.util.Optional;

public interface DiaService {
    public List<Dia> listar();

    public Dia guardar(Dia dia);

    public Dia actualizar(Dia dia);

    public Optional<Dia> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
