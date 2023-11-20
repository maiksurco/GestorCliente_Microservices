package maik.example.msnutricion.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msnutricion.entity.Nutricion;
import maik.example.msnutricion.service.NutricionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutricion")
public class NutricionController {

    @Autowired
    private NutricionService nutricionService;

    @CircuitBreaker(name = "nutricionListarAllCB", fallbackMethod = "fallBackNutricionListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Nutricion>> list() {
        return ResponseEntity.ok(nutricionService.listar());
    }

    @CircuitBreaker(name = "nutricionCreateCB", fallbackMethod = "fallBackNutricionCreateCB")
    @PostMapping()
    public ResponseEntity<Nutricion> save(@RequestBody Nutricion nutricion) {
        return ResponseEntity.ok(nutricionService.guardar(nutricion));
    }

    @CircuitBreaker(name = "nutricionEditCB", fallbackMethod = "fallBackNutricionEditCB")
    @PutMapping()
    public ResponseEntity<Nutricion> update(@RequestBody Nutricion nutricion) {
        return ResponseEntity.ok(nutricionService.actualizar(nutricion));
    }

    @CircuitBreaker(name = "nutricionListarPorIdCB", fallbackMethod = "fallBackNutricionListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Nutricion> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(nutricionService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "nutricionDeleteCB", fallbackMethod = "fallBackNutricionDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Nutricion>> deleteById(@PathVariable(required = true) Integer id) {
        nutricionService.eliminarPorId(id);
        return ResponseEntity.ok(nutricionService.listar());
    }
    private ResponseEntity<Nutricion> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Nutricion socio = new Nutricion();
        socio.setId(90000);
        return ResponseEntity.ok().body(socio);
    }
}
