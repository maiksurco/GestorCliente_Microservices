package maik.example.msfitventas.service.impl;
import maik.example.msfitventas.dto.Producto;
import maik.example.msfitventas.dto.Servicios;
import maik.example.msfitventas.dto.Socio;
import maik.example.msfitventas.dto.Workers;
import maik.example.msfitventas.entity.VentaDetalle;
import maik.example.msfitventas.entity.VentasEntity;
import maik.example.msfitventas.feign.ProductoFeign;
import maik.example.msfitventas.feign.ServiciosFeign;
import maik.example.msfitventas.feign.SocioFeign;
import maik.example.msfitventas.feign.WorkersFeign;
import maik.example.msfitventas.repository.VentasRepository;
import maik.example.msfitventas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentasServiceImpl implements VentasService {
    @Autowired
    private VentasRepository ventasRepository;
    @Autowired
    private ProductoFeign productoFeign;
    @Autowired
    private ServiciosFeign serviciosFeign;
    @Autowired
    private SocioFeign socioFeign;
    @Autowired
    private WorkersFeign workersFeign;

    @Override
    public List<VentasEntity> listar() {
        return ventasRepository.findAll();}
    @Override
    public VentasEntity guardar(VentasEntity ventasEntity) {
        return ventasRepository.save(ventasEntity);}
    @Override
    public VentasEntity actualizar(VentasEntity ventasEntity) {
        return ventasRepository.save(ventasEntity);}
    @Override
    public Optional<VentasEntity> listarPorId(Integer id) {
        VentasEntity ventasEntity = ventasRepository.findById(id).get();
        Socio socio = socioFeign.listById(ventasEntity.getSocioId()).getBody();
        List<VentaDetalle> ventaDetalles = ventasEntity.getDetalles().stream().map(ventaDetalle -> {
            Producto producto = productoFeign.listById(ventaDetalle.getProductoId()).getBody();
            ventaDetalle.setProducto(producto);
            Servicios servicios = serviciosFeign.listById(ventaDetalle.getServiciosId()).getBody();
            ventaDetalle.setServicios(servicios);
            Workers workers = workersFeign.listById(ventaDetalle.getWorkersId()).getBody();
            ventaDetalle.setWorkers(workers);
            return ventaDetalle;
        }).collect(Collectors.toList());
        ventasEntity.setDetalles(ventaDetalles);
        ventasEntity.setSocio(socio);
        return Optional.of(ventasEntity);

    }

    @Override
    public void eliminarPorId(Integer id) {
        ventasRepository.deleteById(id);}
}
