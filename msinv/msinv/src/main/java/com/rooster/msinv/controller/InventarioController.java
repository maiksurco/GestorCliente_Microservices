package com.rooster.msinv.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rooster.msinv.entity.Inventario;
import com.rooster.msinv.service.InventarioService;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @CircuitBreaker(name = "invetarioListarAllCB", fallbackMethod =
            "fallBackInvetarioListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Inventario>> list() {
        return ResponseEntity.ok().body(inventarioService.listar());
    }

    @CircuitBreaker(name = "invetarioCreateCB", fallbackMethod =
            "fallBackInvetarioCreateCB")
    @PostMapping()
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.guardar(inventario));
    }

    @CircuitBreaker(name = "invetarioEditCB", fallbackMethod =
            "fallBackInvetarioEditCB")
    @PutMapping()
    public ResponseEntity<Inventario> update(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.actualizar(inventario));
    }

    @CircuitBreaker(name = "invetarioListarPorIdCB", fallbackMethod =
            "fallBackInvetarioListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(inventarioService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "invetarioDeleteCB", fallbackMethod =
            "fallBackInvetarioDeleteCB")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        inventarioService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
    private ResponseEntity<Inventario>
    fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
                                RuntimeException e) {
        Inventario inventario = new Inventario();
        inventario.setId(90000);
        return ResponseEntity.ok().body(inventario);
    }
    
}
