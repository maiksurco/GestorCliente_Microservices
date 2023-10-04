package com.example.msfacturas.repository;

import com.example.msfacturas.entity.FacturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturasRepository extends JpaRepository<FacturasEntity,Integer> {
}
