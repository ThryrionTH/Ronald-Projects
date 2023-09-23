package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product>{
    
    @Query("select p from Product p where (:id=0 or p.tipo_producto.id=:id) and p.active=1")
    public List<Product> findByIdTypeProduct(int id);
    
    @Query("select p from Product p where (:id=0 or p.tipo_producto.id=:id) and p.active=1" + " and LOWER(p.nombre) like %:s%")
  //  @Query("select p from Product p where (:id=0 or p.tipo_producto.id=:id) and p.active=1")
    public Page<Product> findByIdTypeProductPage(int id, String s, Pageable pageable);

    Optional<Product> findByNombreAndActive(String nombre, int active);

    Optional<Product> findByCodigoAndActive(String codigo, int active);
}
