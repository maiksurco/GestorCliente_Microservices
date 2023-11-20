package maik.example.msingresopro.service;

import maik.example.msingresopro.entity.IngresosProducto;

import java.util.List;
import java.util.Optional;

public interface IngresosProductoService {
    public List<IngresosProducto> listar();

    public IngresosProducto guardar(IngresosProducto ingresosProducto);

    public IngresosProducto actualizar(IngresosProducto ingresosProducto);

    public Optional<IngresosProducto> listarPorId(Integer id);

    public void eliminarPorId(Integer id);

}
