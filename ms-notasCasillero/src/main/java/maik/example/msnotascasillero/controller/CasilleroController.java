package maik.example.msnotascasillero.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msnotascasillero.entity.Casillero;
import maik.example.msnotascasillero.service.CasilleroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casillero")
public class CasilleroController {
    @Autowired
    private CasilleroService casilleroService;

    @CircuitBreaker(name = "socioListarAllCB", fallbackMethod = "fallBackSocioListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Casillero>> list() {
        return ResponseEntity.ok(casilleroService.listar());
    }

    @CircuitBreaker(name = "socioCreateCB", fallbackMethod = "fallBackSocioCreateCB")
    @PostMapping()
    public ResponseEntity<Casillero> save(@RequestBody Casillero casillero) {
        return ResponseEntity.ok(casilleroService.guardar(casillero));
    }

    @CircuitBreaker(name = "socioEditCB", fallbackMethod = "fallBackSocioEditCB")
    @PutMapping()
    public ResponseEntity<Casillero> update(@RequestBody Casillero casillero) {
        return ResponseEntity.ok(casilleroService.actualizar(casillero));
    }

    @CircuitBreaker(name = "socioListarPorIdCB", fallbackMethod = "fallBackSocioListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Casillero> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(casilleroService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "socioDeleteCB", fallbackMethod = "fallBacksocioDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Casillero>> deleteById(@PathVariable(required = true) Integer id) {
        casilleroService.eliminarPorId(id);
        return ResponseEntity.ok(casilleroService.listar());
    }
    private ResponseEntity<Casillero> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Casillero casillero = new Casillero();
        casillero.setId(90000);
        return ResponseEntity.ok().body(casillero);
    }

}
