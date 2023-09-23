package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductAnimal;

@Repository
public interface ProductAnimalRepository extends BaseRepository<ProductAnimal>{
    
    @Query("SELECT pa FROM ProductAnimal pa WHERE pa.animal = :animal")
    Optional<ProductAnimal> findByAnimal(String animal);

    Optional<ProductAnimal> findByAnimalAndActive(String animal, int active);

}
