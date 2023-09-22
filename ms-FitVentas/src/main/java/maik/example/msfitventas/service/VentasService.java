package maik.example.msfitventas.service;
import maik.example.msfitventas.entity.VentasEntity;
import java.util.List;
import java.util.Optional;

public interface VentasService {
    public List<VentasEntity> listar();

    public VentasEntity guardar(VentasEntity ventasEntity);

    public VentasEntity actualizar(VentasEntity ventasEntity);

    public Optional<VentasEntity> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
