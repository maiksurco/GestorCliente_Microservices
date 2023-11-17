package maik.example.msdia.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msdia.entity.Dia;
import maik.example.msdia.service.DiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dia")
public class DiaController {

    @Autowired
    DiaService diaService;

    @CircuitBreaker(name = "diaListarAllCB", fallbackMethod = "fallBackDiaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Dia>> list() {
        return ResponseEntity.ok(diaService.listar());}

    @CircuitBreaker(name = "diaCreateCB", fallbackMethod = "fallBackDiaCreateCB")
    @PostMapping()
    public ResponseEntity<Dia> save(@RequestBody Dia dia) {
        return ResponseEntity.ok(diaService.guardar(dia));}

    @CircuitBreaker(name = "diaEditCB", fallbackMethod = "fallBackDiaEditCB")
    @PutMapping()
    public ResponseEntity<Dia> update(@RequestBody Dia dia) {
        return ResponseEntity.ok(diaService.actualizar(dia));}


    @CircuitBreaker(name = "diaListarPorIdCB", fallbackMethod = "fallBackDiaListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Dia> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(diaService.listarPorId(id).get());}

    @CircuitBreaker(name = "diaDeleteCB", fallbackMethod = "fallBackDiaDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Dia>> deleteById(@PathVariable(required = true) Integer id) {
        diaService.eliminarPorId(id);
        return ResponseEntity.ok(diaService.listar());}

    private ResponseEntity<Dia> fallBackDiaListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Dia dia = new Dia();
        dia.setId(90000);
        return ResponseEntity.ok().body(dia);
    }

}
