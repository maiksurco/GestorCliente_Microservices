package maik.example.msusuarios.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import maik.example.msusuarios.entity.Usuarios;
import maik.example.msusuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @CircuitBreaker(name = "usuariosListarAllCB", fallbackMethod = "fallBackSocioListarAllCB")
    @GetMapping()
    public ResponseEntity<List<Usuarios>> list() {
        return ResponseEntity.ok(usuariosService.listar());
    }

    @CircuitBreaker(name = "socioCreateCB", fallbackMethod = "fallBackSocioCreateCB")
    @PostMapping()
    public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(usuariosService.guardar(usuarios));
    }

    @CircuitBreaker(name = "socioEditCB", fallbackMethod = "fallBackSocioEditCB")
    @PutMapping()
    public ResponseEntity<Usuarios> update(@RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(usuariosService.actualizar(usuarios));
    }

    @CircuitBreaker(name = "socioListarPorIdCB", fallbackMethod = "fallBackSocioListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(usuariosService.listarPorId(id).get());
    }

    @CircuitBreaker(name = "socioDeleteCB", fallbackMethod = "fallBacksocioDeleteCB")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Usuarios>> deleteById(@PathVariable(required = true) Integer id) {
        usuariosService.eliminarPorId(id);
        return ResponseEntity.ok(usuariosService.listar());
    }
    private ResponseEntity<Usuarios> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Usuarios socio = new Usuarios();
        socio.setId(90000);
        return ResponseEntity.ok().body(socio);
    }

}
