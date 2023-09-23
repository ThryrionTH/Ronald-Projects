package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductBrand;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.ProductBrandRepository;

@Service
public class ProductBrandService extends BaseService<ProductBrand> {
    
    private ProductBrandRepository repository;

    public ProductBrandService(ProductBrandRepository repository){
        super(repository);
        this.repository = repository;
    } 

    @Override
    public ProductBrand update(ProductBrand updatedBrand) {
        Optional<ProductBrand> optionalBrand = repository.findById(updatedBrand.getId());
        if(optionalBrand.isPresent()){
            ProductBrand productBrand = optionalBrand.get();
            productBrand.setNombremarca(updatedBrand.getNombremarca());
            return repository.save(productBrand);
        }else{
            return null;
        }
    }

    public ProductBrand findByNombre_marcaAndActive(String nombremarca, int active) {
        Optional<ProductBrand> optionalProductBrand = repository.findByNombremarcaAndActive(nombremarca, active);
        if (optionalProductBrand.isPresent()) {
            return optionalProductBrand.get();
        } else {
            return null; 
        }
    }

    public ProductBrand findByNombre_marca(String nombremarca){
        Optional<ProductBrand> productBrand = repository.findByNombremarca(nombremarca);
        if(productBrand.isPresent()){
            return productBrand.get();
        } else{
            return null;
        }
    }
} 