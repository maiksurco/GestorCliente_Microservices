package maik.example.msprodcat.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msprodcat.entity.Categoria;
import maik.example.msprodcat.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @CircuitBreaker(name = "categoriaListarAllCB", fallbackMethod =
            "fallBackcategoriaListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Categoria>> list() {
        return ResponseEntity.ok().body(categoriaService.listar());
    }

    @CircuitBreaker(name = "categoriaCreateCB", fallbackMethod =
            "fallBackcategoriaCreateCB")
    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }

    @CircuitBreaker(name = "categoriaEditCB", fallbackMethod =
            "fallBackcategoriaEditCB")
    @PutMapping()
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.actualizar(categoria));
    }

    @CircuitBreaker(name = "categoriaListarPorIdCB", fallbackMethod =
            "fallBackPedidoListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(categoriaService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "categoriaDeleteCB", fallbackMethod =
            "fallBackcategoriaDeleteCB")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        categoriaService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
    private ResponseEntity<Categoria>
    fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
                                RuntimeException e) {
        Categoria categoria = new Categoria();
        categoria.setId(90000);
        return ResponseEntity.ok().body(categoria);
    }
    private ResponseEntity<String> fallBackcategoriaCreateCB(Categoria categoria, RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido.");
    }

    private ResponseEntity<String> fallBackPedidoEditCB(Integer id, Categoria pedido, RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al editar el pedido con ID: " + id);
    }

    // Fallback method para la operación de eliminación

    private  ResponseEntity<String> fallBackPedidoDeleteCB(Integer id, RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el pedido con ID: " +id);
    }
}

