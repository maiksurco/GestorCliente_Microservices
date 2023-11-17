package maik.example.msnutricion.service;

import maik.example.msnutricion.entity.Nutricion;

import java.util.List;
import java.util.Optional;

public interface NutricionService {

    public List<Nutricion> listar();

    public Nutricion guardar(Nutricion nutricion);

    public Nutricion actualizar(Nutricion nutricion);

    public Optional<Nutricion> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
