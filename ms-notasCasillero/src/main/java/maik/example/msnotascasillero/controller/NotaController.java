package maik.example.msnotascasillero.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msnotascasillero.entity.Nota;
import maik.example.msnotascasillero.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @CircuitBreaker(name = "notaListarAllCB", fallbackMethod = "fallBackNotaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Nota>> list() {
        return ResponseEntity.ok(notaService.listar());
    }

    @CircuitBreaker(name = "notaCreateCB", fallbackMethod = "fallBackNotaCreateCB")
    @PostMapping()
    public ResponseEntity<Nota> save(@RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.guardar(nota));
    }

    @CircuitBreaker(name = "notaEditCB", fallbackMethod = "fallBackNotaEditCB")
    @PutMapping()
    public ResponseEntity<Nota> update(@RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.actualizar(nota));
    }

    @CircuitBreaker(name = "notaListarPorIdCB", fallbackMethod = "fallBackNotaListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Nota> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(notaService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "notaDeleteCB", fallbackMethod = "fallBackNotaDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Nota>> deleteById(@PathVariable(required = true) Integer id) {
        notaService.eliminarPorId(id);
        return ResponseEntity.ok(notaService.listar());
    }
    private ResponseEntity<Nota> fallBackNotaListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Nota nota = new Nota();
        nota.setId(90000);
        return ResponseEntity.ok().body(nota);
    }

}
