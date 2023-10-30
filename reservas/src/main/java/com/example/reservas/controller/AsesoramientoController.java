package com.example.reservas.controller;

import com.example.reservas.entity.Asesoramiento;
import com.example.reservas.entity.Reserva;
import com.example.reservas.service.AsesoramientoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asesoramiento")
public class AsesoramientoController {
    @Autowired
    private AsesoramientoService asesoramientoService;

    @CircuitBreaker(name = "reservasListarAllCB", fallbackMethod =
            "fallBackReservasListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Asesoramiento>> list() {
        return ResponseEntity.ok(asesoramientoService.listar());
    }

    @CircuitBreaker(name = "reservasCreateCB", fallbackMethod =
            "fallBackReservasCreateCB")
    @PostMapping()
    public ResponseEntity<Asesoramiento> save(@RequestBody Asesoramiento asesoramiento) {
        return ResponseEntity.ok(asesoramientoService.guardar(asesoramiento));
    }

    @CircuitBreaker(name = "reservasEditCB", fallbackMethod =
            "fallBackReservasEditCB")
    @PutMapping()
    public ResponseEntity<Asesoramiento> update(@RequestBody Asesoramiento asesoramiento) {
        return ResponseEntity.ok(asesoramientoService.actualizar(asesoramiento));
    }

    @CircuitBreaker(name = "reservasListarPorIdCB", fallbackMethod =
            "fallBackReservasListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Asesoramiento> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(asesoramientoService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "reservasDeleteCB", fallbackMethod =
            "fallBackReservasDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Asesoramiento>> deleteById(@PathVariable(required = true) Integer id) {
        asesoramientoService.eliminarPorId(id);
        return ResponseEntity.ok(asesoramientoService.listar());
    }
    private ResponseEntity<Reserva>
    fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
                                RuntimeException e) {
        Asesoramiento asesoramiento = new Asesoramiento();
        asesoramiento.setId(90000);
        return ResponseEntity.ok().body(asesoramiento.getReserva());
    }

}
