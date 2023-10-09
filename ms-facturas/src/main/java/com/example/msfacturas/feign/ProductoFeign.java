package com.example.msfacturas.feign;

import com.example.msfacturas.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "prodcat-service", path = "/producto")
public interface ProductoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Integer id);
}
