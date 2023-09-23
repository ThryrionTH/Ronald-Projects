package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    List<Factura> findAll();

    @Query("SELECT f FROM Factura f WHERE f.cliente.id = :id")
    List<Factura> findByIdClent(Long id);
}
