package com.example.msfacturas.service.impl;

import com.example.msfacturas.entity.FacturasEntity;
import com.example.msfacturas.repository.FacturasRepository;
import com.example.msfacturas.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacturasServiceImpl implements FacturasService {
    @Autowired
    private FacturasRepository ventasRepository;
    @Override
    public List<FacturasEntity> listar() {
        return ventasRepository.findAll();}
    @Override
    public FacturasEntity guardar(FacturasEntity ventasEntity) {
        return ventasRepository.save(ventasEntity);}
    @Override
    public FacturasEntity actualizar(FacturasEntity ventasEntity) {
        return ventasRepository.save(ventasEntity);}
    @Override
    public Optional<FacturasEntity> listarPorId(Integer id) {
        return ventasRepository.findById(id);}
    @Override
    public void eliminarPorId(Integer id) {
        ventasRepository.deleteById(id);}
}
