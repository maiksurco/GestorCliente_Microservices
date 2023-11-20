package maik.example.msingresopro.service.impl;

import maik.example.msingresopro.dto.Usuarios;
import maik.example.msingresopro.entity.IngresosProducto;
import maik.example.msingresopro.feign.UsuariosFeign;
import maik.example.msingresopro.repository.IngresosProductoRepository;
import maik.example.msingresopro.service.IngresosProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresosProductoServiceImpl implements IngresosProductoService {

    @Autowired
    private IngresosProductoRepository ingresosProductoRepository;
    @Autowired
    private UsuariosFeign usuariosFeign;


    @Override
    public List<IngresosProducto> listar() {
        return ingresosProductoRepository.findAll();
    }

    @Override
    public IngresosProducto guardar(IngresosProducto ingresosProducto) {
        return ingresosProductoRepository.save(ingresosProducto);
    }

    @Override
    public IngresosProducto actualizar(IngresosProducto ingresosProducto) {
        return ingresosProductoRepository.save(ingresosProducto);
    }

    @Override
    public Optional<IngresosProducto> listarPorId(Integer id) {
        IngresosProducto ingresosProducto = ingresosProductoRepository.findById(id).get();
        Usuarios usuarios = usuariosFeign.listById(ingresosProducto.getUsuariosId()).getBody();
        ingresosProducto.setUsuarios(usuarios);
        return Optional.of(ingresosProducto);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ingresosProductoRepository.deleteById(id);

    }
}
