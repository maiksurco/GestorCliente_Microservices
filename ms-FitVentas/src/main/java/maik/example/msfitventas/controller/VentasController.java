package maik.example.msfitventas.controller;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msfitventas.entity.VentasEntity;
import maik.example.msfitventas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    VentasService ventasService;

    @CircuitBreaker(name = "ventaListarAllCB", fallbackMethod = "fallBackVentaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<VentasEntity>> list() {
        return ResponseEntity.ok(ventasService.listar());}

    @CircuitBreaker(name = "ventaCreateCB", fallbackMethod = "fallBackVentaCreateCB")
    @PostMapping()
    public ResponseEntity<VentasEntity> save(@RequestBody VentasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.guardar(ventasEntity));}

    @CircuitBreaker(name = "ventaEditCB", fallbackMethod = "fallBackVentaEditCB")
    @PutMapping()
    public ResponseEntity<VentasEntity> update(@RequestBody VentasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.actualizar(ventasEntity));}


    @CircuitBreaker(name = "ventaListarPorIdCB", fallbackMethod = "fallBackVentaListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<VentasEntity> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ventasService.listarPorId(id).get());}

    @CircuitBreaker(name = "ventaDeleteCB", fallbackMethod = "fallBackVentaDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<VentasEntity>> deleteById(@PathVariable(required = true) Integer id) {
        ventasService.eliminarPorId(id);
        return ResponseEntity.ok(ventasService.listar());}

    private ResponseEntity<VentasEntity> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        VentasEntity ventasEntity = new VentasEntity();
        ventasEntity.setId(90000);
        return ResponseEntity.ok().body(ventasEntity);
    }

}
