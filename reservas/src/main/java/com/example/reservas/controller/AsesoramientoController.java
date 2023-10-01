package com.example.reservas.controller;

import com.example.reservas.entity.Asesoramiento;
import com.example.reservas.service.AsesoramientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asesoramiento")
public class AsesoramientoController {
    @Autowired
    private AsesoramientoService asesoramientoService;

    @GetMapping()
    public ResponseEntity<List<Asesoramiento>> list() {
        return ResponseEntity.ok(asesoramientoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Asesoramiento> save(@RequestBody Asesoramiento asesoramiento) {
        return ResponseEntity.ok(asesoramientoService.guardar(asesoramiento));
    }

    @PutMapping()
    public ResponseEntity<Asesoramiento> update(@RequestBody Asesoramiento asesoramiento) {
        return ResponseEntity.ok(asesoramientoService.actualizar(asesoramiento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asesoramiento> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(asesoramientoService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Asesoramiento>> deleteById(@PathVariable(required = true) Integer id) {
        asesoramientoService.eliminarPorId(id);
        return ResponseEntity.ok(asesoramientoService.listar());
    }
}
