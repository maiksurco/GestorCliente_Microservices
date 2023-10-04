package com.example.msfacturas.feign;

import com.example.msfacturas.dto.Servicios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicios-service", path = "/servicios")
public interface ServiciosFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Servicios> listById(@PathVariable(required = true) Integer id);
}
