package maik.example.msfitventas.feign;

import maik.example.msfitventas.dto.Workers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "workers-service",path="/workers")
public interface WorkersFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Workers> listById(@PathVariable(required = true) Integer id);
}
