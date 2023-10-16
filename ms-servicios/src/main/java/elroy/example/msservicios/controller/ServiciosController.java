package elroy.example.msservicios.controller;

import elroy.example.msservicios.entity.Servicios;
import elroy.example.msservicios.service.ServiciosService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    @Autowired
    private ServiciosService serviciosService;

    @GetMapping()
    public ResponseEntity<List<Servicios>> list() {
        return ResponseEntity.ok(serviciosService.listar());
    }

    @PostMapping()
    public ResponseEntity<Servicios> save(@RequestBody Servicios servicios) {
        return ResponseEntity.ok(serviciosService.guardar(servicios));
    }

    @PutMapping()
    public ResponseEntity<Servicios> update(@RequestBody Servicios servicios) {
        return ResponseEntity.ok(serviciosService.actualizar(servicios));
    }
    @CircuitBreaker(name = "pedidoListarPorIdCB", fallbackMethod =
            "fallBackPedidoListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Servicios> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(serviciosService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Servicios>> deleteById(@PathVariable(required = true) Integer id) {
        serviciosService.eliminarPorId(id);
        return ResponseEntity.ok(serviciosService.listar());
    }
    private ResponseEntity<Servicios>
    fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
                                RuntimeException e) {
        Servicios servicios = new Servicios();
        servicios.setId(90000);
        return ResponseEntity.ok().body(servicios);
    }
}
