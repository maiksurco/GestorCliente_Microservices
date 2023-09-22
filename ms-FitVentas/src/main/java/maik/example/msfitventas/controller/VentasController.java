package maik.example.msfitventas.controller;
import maik.example.msfitventas.entity.VentasEntity;
import maik.example.msfitventas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    VentasService ventasService;
    @GetMapping()
    public ResponseEntity<List<VentasEntity>> list() {
        return ResponseEntity.ok(ventasService.listar());}
    @PostMapping()
    public ResponseEntity<VentasEntity> save(@RequestBody VentasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.guardar(ventasEntity));}
    @PutMapping()
    public ResponseEntity<VentasEntity> update(@RequestBody VentasEntity ventasEntity) {
        return ResponseEntity.ok(ventasService.actualizar(ventasEntity));}
    @GetMapping("/{id}")
    public ResponseEntity<VentasEntity> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(ventasService.listarPorId(id).get());}
    @DeleteMapping("/{id}")
    public ResponseEntity<List<VentasEntity>> deleteById(@PathVariable(required = true) Integer id) {
        ventasService.eliminarPorId(id);
        return ResponseEntity.ok(ventasService.listar());}
}
