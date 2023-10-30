package maik.example.mssocios.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    @CircuitBreaker(name = "socioDeleteCB", fallbackMethod = "fallBacksocioDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Socio>> deleteById(@PathVariable(required = true) Integer id) {
        socioService.eliminarPorId(id);
        return ResponseEntity.ok(socioService.listar());
    }
    private ResponseEntity<Socio> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Socio socio = new Socio();
        socio.setId(90000);
        return ResponseEntity.ok().body(socio);
    }

}
