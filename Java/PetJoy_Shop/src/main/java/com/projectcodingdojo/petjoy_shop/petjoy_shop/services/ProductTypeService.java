package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.ProductType;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.ProductTypeRepository;

@Service
public class ProductTypeService extends BaseService<ProductType>{

    private ProductTypeRepository repository;

    public ProductTypeService(ProductTypeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public ProductType findByCategoriaAndActive(String categoria, int active) {
        Optional<ProductType> optionalProductType = repository.findByCategoriaAndActive(categoria, active);
        if (optionalProductType.isPresent()) {
            return optionalProductType.get();
        } else {
            return null;
        }
    }

    public ProductType findByCategoria(String categoria){
        Optional <ProductType> productType = repository.findByCategoria(categoria);
        if(productType.isPresent()){
            return productType.get();
        }else{
            return null;
        }
    }
    
    

}