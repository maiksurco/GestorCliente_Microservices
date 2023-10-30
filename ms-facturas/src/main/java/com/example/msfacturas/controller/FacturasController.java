package com.example.msfacturas.controller;
import com.example.msfacturas.entity.FacturasEntity;
import com.example.msfacturas.service.FacturasService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ventas")
public class FacturasController {
    @Autowired
    FacturasService ventasService;

    @CircuitBreaker(name = "facturasListarAllCB", fallbackMethod = "fallBackFacturasListarAllCB")
    @GetMapping()
    public ResponseEntity<List<FacturasEntity>> list() {
        return ResponseEntity.ok(ventasService.listar());}

    @CircuitBreaker(name = "facturasCreateCB", fallbackMethod = "fallBackFacturasCreateCB")
    @PostMapping()
    public ResponseEntity<FacturasEntity> save(@RequestBody FacturasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.guardar(ventasEntity));}

    @CircuitBreaker(name = "facturasEditCB", fallbackMethod = "fallBackFacturasEditCB")
    @PutMapping()
    public ResponseEntity<FacturasEntity> update(@RequestBody FacturasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.actualizar(ventasEntity));}

    @CircuitBreaker(name = "facturasListarPorIdCB", fallbackMethod = "fallBackFacturasListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<FacturasEntity> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ventasService.listarPorId(id).get());}

    @CircuitBreaker(name = "facturasDeleteCB", fallbackMethod = "fallBackFacturasDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<FacturasEntity>> deleteById(@PathVariable(required = true) Integer id) {
        ventasService.eliminarPorId(id);
        return ResponseEntity.ok(ventasService.listar());}
    private ResponseEntity<FacturasEntity> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        FacturasEntity facturasEntity = new FacturasEntity();
        facturasEntity.setId(90000);
        return ResponseEntity.ok().body(facturasEntity);
    }

}
