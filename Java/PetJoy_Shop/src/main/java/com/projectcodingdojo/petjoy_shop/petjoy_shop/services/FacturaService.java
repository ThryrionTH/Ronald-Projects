package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.*;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.*;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository repository;

    @Transactional
    public Factura save(Factura obj) {
        return repository.save(obj);
    }

    public List<Factura> getAllBills() {
        return repository.findAll();
    }

    public Factura findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Factura> findByIdClent(Long id) {
        return repository.findByIdClent(id);
    }
}
