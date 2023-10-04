package com.example.msfacturas.controller;
import com.example.msfacturas.entity.FacturasEntity;
import com.example.msfacturas.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ventas")
public class FacturasController {
    @Autowired
    FacturasService ventasService;
    @GetMapping()
    public ResponseEntity<List<FacturasEntity>> list() {
        return ResponseEntity.ok(ventasService.listar());}
    @PostMapping()
    public ResponseEntity<FacturasEntity> save(@RequestBody FacturasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.guardar(ventasEntity));}
    @PutMapping()
    public ResponseEntity<FacturasEntity> update(@RequestBody FacturasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.actualizar(ventasEntity));}
    @GetMapping("/{id}")
    public ResponseEntity<FacturasEntity> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ventasService.listarPorId(id).get());}
    @DeleteMapping("/{id}")
    public ResponseEntity<List<FacturasEntity>> deleteById(@PathVariable(required = true) Integer id) {
        ventasService.eliminarPorId(id);
        return ResponseEntity.ok(ventasService.listar());}
}
