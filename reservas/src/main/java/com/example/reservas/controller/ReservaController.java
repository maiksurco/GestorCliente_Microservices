package com.example.reservas.controller;

import com.example.reservas.entity.Reserva;
import com.example.reservas.service.ReservaService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @CircuitBreaker(name = "reservasListarAllCB", fallbackMethod =
            "fallBackReservasListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Reserva>> list() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @CircuitBreaker(name = "reservasCreateCB", fallbackMethod =
            "fallBackReservasCreateCB")
    @PostMapping()
    public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.guardar(reserva));
    }

    @CircuitBreaker(name = "reservasEditCB", fallbackMethod =
            "fallBackReservasEditCB")
    @PutMapping()
    public ResponseEntity<Reserva> update(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.actualizar(reserva));
    }

    @CircuitBreaker(name = "pedidoListarPorIdCB", fallbackMethod =
            "fallBackPedidoListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(reservaService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "reservasDeleteCB", fallbackMethod =
            "fallBackReservasDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Reserva>> deleteById(@PathVariable(required = true) Integer id) {
        reservaService.eliminarPorId(id);
        return ResponseEntity.ok(reservaService.listar());
    }

    private ResponseEntity<Reserva>
    fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id,
                                RuntimeException e) {
        Reserva reserva = new Reserva();
        reserva.setId(90000);
        return ResponseEntity.ok().body(reserva);}

}