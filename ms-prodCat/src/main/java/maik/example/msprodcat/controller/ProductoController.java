package maik.example.msprodcat.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msprodcat.entity.Producto;
import maik.example.msprodcat.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @CircuitBreaker(name = "categoriaListarAllCB", fallbackMethod = "fallBackcategoriaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Producto>> list() {

        return ResponseEntity.ok().body(productoService.listar());

    }

    @CircuitBreaker(name = "categoriaCreateCB", fallbackMethod = "fallBackcategoriaCreateCB")
    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @CircuitBreaker(name = "categoriaEditCB", fallbackMethod = "fallBackcategoriaEditCB")
    @PutMapping()
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualizar(producto));
    }

    @CircuitBreaker(name = "pedidoListarPorIdCB", fallbackMethod = "fallBackPedidoListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(productoService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "categoriaDeleteCB", fallbackMethod = "fallBackcategoriaDeleteCB")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        productoService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

    private ResponseEntity<Producto> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
            RuntimeException e) {
        Producto producto = new Producto();
        producto.setId(90000);
        return ResponseEntity.ok().body(producto);
    }
}
