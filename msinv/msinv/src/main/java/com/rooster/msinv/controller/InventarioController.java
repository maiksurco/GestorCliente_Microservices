package com.rooster.msinv.controller;

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

    @GetMapping()
    public ResponseEntity<List<Inventario>> list() {

        return ResponseEntity.ok().body(inventarioService.listar());

    }

    @PostMapping()
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.guardar(inventario));
    }

    @PutMapping()
    public ResponseEntity<Inventario> update(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.actualizar(inventario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(inventarioService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        inventarioService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
    
}
