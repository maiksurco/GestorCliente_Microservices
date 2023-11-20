package maik.example.msnotascasillero.service;


import maik.example.msnotascasillero.entity.Nota;
import java.util.List;
import java.util.Optional;
public interface NotaService {
    public List<Nota> listar();

    public Nota guardar(Nota nota);

    public Nota actualizar(Nota nota);

    public Optional<Nota> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
