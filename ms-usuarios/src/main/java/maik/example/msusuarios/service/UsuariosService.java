package maik.example.msusuarios.service;

import maik.example.msusuarios.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    public List<Usuarios> listar();

    public Usuarios guardar(Usuarios usuarios);

    public Usuarios actualizar(Usuarios usuarios);

    public Optional<Usuarios> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
