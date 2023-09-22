package maik.example.msfitventas.service.impl;
import maik.example.msfitventas.entity.VentasEntity;
import maik.example.msfitventas.repository.VentasRepository;
import maik.example.msfitventas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VentasServiceImpl implements VentasService {
    @Autowired
    private VentasRepository ventasRepository;
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
        return ventasRepository.findById(id);}
    @Override
    public void eliminarPorId(Integer id) {
        ventasRepository.deleteById(id);}
}
