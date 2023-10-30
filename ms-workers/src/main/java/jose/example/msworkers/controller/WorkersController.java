package jose.example.msworkers.controller;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jose.example.msworkers.entity.Workers;
import jose.example.msworkers.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/workers")
public class WorkersController {
    @Autowired
    private WorkersService workersService;

    @CircuitBreaker(name = "workersListarAllCB", fallbackMethod = "fallBackWorkersListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Workers>> list() {
        return ResponseEntity.ok().body(workersService.listar());
    }

    @CircuitBreaker(name = "workersCreateCB", fallbackMethod = "fallBackWorkersCreateCB")
    @PostMapping()
    public ResponseEntity<Workers> save(@RequestBody Workers workers) {
        return ResponseEntity.ok(workersService.guardar(workers));
    }

    @CircuitBreaker(name = "workersEditCB", fallbackMethod = "fallBackWorkersEditCB")
    @PutMapping()
    public ResponseEntity<Workers> update(@RequestBody Workers workers) {
        return ResponseEntity.ok(workersService.actualizar(workers));
    }

    @CircuitBreaker(name = "workersListarPorIdCB", fallbackMethod = "fallBackWorkersListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Workers> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(workersService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "workersDeleteCB", fallbackMethod = "fallBackWorkersDeleteCB")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        workersService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

    private ResponseEntity<Workers> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Workers workers = new Workers();
        workers.setId(90000);
        return ResponseEntity.ok().body(workers);
    }

}
