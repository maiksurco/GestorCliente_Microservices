package elroy.example.msservicios.service;

import elroy.example.msservicios.entity.Servicios;

import java.util.List;
import java.util.Optional;

public interface ServiciosService {
    public List<Servicios> listar();

    public Servicios guardar(Servicios socio);

    public Servicios actualizar(Servicios socio);

    public Optional<Servicios> listarPorId(Integer id);

    public void eliminarPorId(Integer id);

}

