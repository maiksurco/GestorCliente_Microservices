package maik.example.mssocios.controller;

import maik.example.mssocios.entity.Socio;
import maik.example.mssocios.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socio")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @GetMapping()
    public ResponseEntity<List<Socio>> list() {
        return ResponseEntity.ok(socioService.listar());
    }

    @PostMapping()
    public ResponseEntity<Socio> save(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.guardar(socio));
    }

    @PutMapping()
    public ResponseEntity<Socio> update(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.actualizar(socio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(socioService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Socio>> deleteById(@PathVariable(required = true) Integer id) {
        socioService.eliminarPorId(id);
        return ResponseEntity.ok(socioService.listar());
    }
}
