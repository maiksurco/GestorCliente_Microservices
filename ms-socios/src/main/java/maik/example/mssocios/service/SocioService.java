package maik.example.mssocios.service;

import maik.example.mssocios.entity.Socio;

import java.util.List;
import java.util.Optional;
public interface SocioService {
    public List<Socio> listar();

    public Socio guardar(Socio socio);

    public Socio actualizar(Socio socio);

    public Optional<Socio> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
