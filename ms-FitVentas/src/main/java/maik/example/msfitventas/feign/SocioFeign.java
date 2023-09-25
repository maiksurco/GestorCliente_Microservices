package maik.example.msfitventas.feign;

import maik.example.msfitventas.dto.Socio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "socio-service", path = "/socio")
public interface SocioFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Socio> listById(@PathVariable(required = true) Integer id);
}
