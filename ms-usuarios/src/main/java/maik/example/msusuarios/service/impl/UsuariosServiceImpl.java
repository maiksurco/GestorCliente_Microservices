package maik.example.msusuarios.service.impl;

import maik.example.msusuarios.entity.Usuarios;
import maik.example.msusuarios.repository.UsuariosRepository;
import maik.example.msusuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> listar() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios guardar(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios actualizar(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Optional<Usuarios> listarPorId(Integer id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuariosRepository.deleteById(id);
    }
}
