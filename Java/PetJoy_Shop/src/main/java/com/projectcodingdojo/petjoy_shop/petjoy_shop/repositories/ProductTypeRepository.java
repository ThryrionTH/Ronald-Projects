package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductType;

@Repository
public interface ProductTypeRepository extends BaseRepository<ProductType> {
    
    @Query("SELECT pt FROM ProductType pt WHERE pt.categoria = :categoria")
    Optional<ProductType> findByCategoria(String categoria);
    
    Optional<ProductType> findByCategoriaAndActive(String categoria, int active);

}
