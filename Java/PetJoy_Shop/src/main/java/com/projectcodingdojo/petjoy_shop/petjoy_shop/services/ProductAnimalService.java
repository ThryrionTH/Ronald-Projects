package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductAnimal;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.ProductAnimalRepository;


@Service
public class ProductAnimalService extends BaseService<ProductAnimal>{

    private ProductAnimalRepository repository;

    public ProductAnimalService(ProductAnimalRepository repository){
        super(repository);
        this.repository = repository;
    }

    public boolean existsByNameActive(String animal, int active) {
        return repository.findByAnimalAndActive(animal, active) != null;
    }

    
    @Override
    public ProductAnimal update(ProductAnimal updatedAnimal) {
        Optional<ProductAnimal> optionalAnimal = repository.findById(updatedAnimal.getId());
        if(optionalAnimal.isPresent()){
            ProductAnimal productAnimal = optionalAnimal.get();
            productAnimal.setAnimal(updatedAnimal.getAnimal());
            return repository.save(productAnimal);
        }else{
            return null;
        }
    }

    public ProductAnimal findByAnimalandActive(String animal, int active) {
        Optional<ProductAnimal> optionalProductAnimal = repository.findByAnimalAndActive(animal, active);
        if (optionalProductAnimal.isPresent()) {
            return optionalProductAnimal.get();
        } else { 
            return null; 
        }
    }

    public ProductAnimal findByNombre_marca(String animal){
        Optional<ProductAnimal> productAnimal = repository.findByAnimal(animal);
        if(productAnimal.isPresent()){
            return productAnimal.get();
        } else{
            return null;
        }
    }
    
} 
