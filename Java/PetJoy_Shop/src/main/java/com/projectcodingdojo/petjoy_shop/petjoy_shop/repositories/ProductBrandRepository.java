package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductBrand;

@Repository
public interface ProductBrandRepository extends BaseRepository<ProductBrand>{
    
    @Query("SELECT pb FROM ProductBrand pb WHERE pb.nombremarca = :nombremarca")
    Optional<ProductBrand> findByNombremarca(String nombremarca);

    Optional<ProductBrand> findByNombremarcaAndActive(String nombremarca, int active);
}
