package maik.example.msnotascasillero.service;

import maik.example.msnotascasillero.entity.Casillero;

import java.util.List;
import java.util.Optional;

public interface CasilleroService {
    public List<Casillero> listar();

    public Casillero guardar(Casillero casillero);

    public Casillero actualizar(Casillero casillero);

    public Optional<Casillero> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
