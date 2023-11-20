package maik.example.msingresopro.feign;


import maik.example.msingresopro.dto.Usuarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-service", path = "/usuarios")
public interface UsuariosFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> listById(@PathVariable(required = true) Integer id);

}
