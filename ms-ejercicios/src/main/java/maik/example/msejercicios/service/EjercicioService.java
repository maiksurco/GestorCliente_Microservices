package maik.example.msejercicios.service;

import maik.example.msejercicios.entity.Ejercicio;

import java.util.List;
import java.util.Optional;

public interface EjercicioService {
    public List<Ejercicio> listar();

    public Ejercicio guardar(Ejercicio ejercicio);

    public Ejercicio actualizar(Ejercicio ejercicio);

    public Optional<Ejercicio> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
