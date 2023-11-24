package maik.example.mssocios.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.mssocios.entity.Socio;
import maik.example.mssocios.repository.SocioRepository;
import maik.example.mssocios.service.SocioService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/socio")
@CrossOrigin(origins = "http://localhost:3000")
public class SocioController {
    @Autowired
    private SocioService socioService;

    @Autowired
    private SocioRepository socioRepository;
    @CircuitBreaker(name = "socioListarAllCB", fallbackMethod = "fallBackSocioListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Socio>> list() {
        return ResponseEntity.ok(socioService.listar());
    }

    @CircuitBreaker(name = "socioCreateCB", fallbackMethod = "fallBackSocioCreateCB")
    @PostMapping()
    public ResponseEntity<Socio> save(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.guardar(socio));
    }

    @CircuitBreaker(name = "socioEditCB", fallbackMethod = "fallBackSocioEditCB")
    @PutMapping()
    public ResponseEntity<Socio> update(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.actualizar(socio));
    }

    @CircuitBreaker(name = "socioListarPorIdCB", fallbackMethod = "fallBackSocioListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Socio> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(socioService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "socioDeleteCB", fallbackMethod = "fallBackSocioDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(required = true) Integer id) {
        Optional<Socio> socio = socioService.listarPorId(id);

        if (socio == null) {
            // Si el socio no se encuentra, devolver un ResponseEntity con el mensaje correspondiente
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Socio con ID " + id + " no encontrado");
        }

        socioService.eliminarPorId(id);

        // Devolver un ResponseEntity con un mensaje de éxito
        return ResponseEntity.ok().body("Socio con ID " + id + " eliminado exitosamente");
    }
    private ResponseEntity<Socio> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Socio socio = new Socio();
        socio.setId(90000);
        return ResponseEntity.ok().body(socio);
    }

}
