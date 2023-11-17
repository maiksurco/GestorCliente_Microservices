package maik.example.msdia.service.impl;

import maik.example.msdia.dto.Servicios;
import maik.example.msdia.entity.Dia;
import maik.example.msdia.feign.ServiciosFeign;
import maik.example.msdia.repository.DiaRepository;
import maik.example.msdia.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DiaServiceImpl implements DiaService {

    @Autowired
    private DiaRepository diaRepository;
    @Autowired
    private ServiciosFeign serviciosFeign;


    @Override
    public List<Dia> listar() {
        return diaRepository.findAll();
    }

    @Override
    public Dia guardar(Dia dia) {
        return diaRepository.save(dia);
    }

    @Override
    public Dia actualizar(Dia dia) {
        return diaRepository.save(dia);
    }

    @Override
    public Optional<Dia> listarPorId(Integer id) {
        Dia dia = diaRepository.findById(id).get();
        Servicios servicios = serviciosFeign.listById(dia.getServiciosId()).getBody();
        dia.setServicios(servicios);
        return Optional.of(dia);
    }

    @Override
    public void eliminarPorId(Integer id) {
        diaRepository.deleteById(id);

    }
}
