package maik.example.msingresopro.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msingresopro.entity.IngresosProducto;
import maik.example.msingresopro.service.IngresosProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresosPro")
public class IngresosProductoController {
    @Autowired
    IngresosProductoService ingresosProductoService;

    @CircuitBreaker(name = "ventaListarAllCB", fallbackMethod = "fallBackVentaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<IngresosProducto>> list() {
        return ResponseEntity.ok(ingresosProductoService.listar());}

    @CircuitBreaker(name = "ventaCreateCB", fallbackMethod = "fallBackVentaCreateCB")
    @PostMapping()
    public ResponseEntity<IngresosProducto> save(@RequestBody IngresosProducto ingresosProducto) {
        return ResponseEntity.ok(ingresosProductoService.guardar(ingresosProducto));}

    @CircuitBreaker(name = "ventaEditCB", fallbackMethod = "fallBackVentaEditCB")
    @PutMapping()
    public ResponseEntity<IngresosProducto> update(@RequestBody IngresosProducto ingresosProducto) {
        return ResponseEntity.ok(ingresosProductoService.actualizar(ingresosProducto));}


    @CircuitBreaker(name = "ventaListarPorIdCB", fallbackMethod = "fallBackVentaListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<IngresosProducto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ingresosProductoService.listarPorId(id).get());}

    @CircuitBreaker(name = "ventaDeleteCB", fallbackMethod = "fallBackVentaDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<IngresosProducto>> deleteById(@PathVariable(required = true) Integer id) {
        ingresosProductoService.eliminarPorId(id);
        return ResponseEntity.ok(ingresosProductoService.listar());}

    private ResponseEntity<IngresosProducto> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        IngresosProducto ingresosProducto = new IngresosProducto();
        ingresosProducto.setId(90000);
        return ResponseEntity.ok().body(ingresosProducto);
    }
}
