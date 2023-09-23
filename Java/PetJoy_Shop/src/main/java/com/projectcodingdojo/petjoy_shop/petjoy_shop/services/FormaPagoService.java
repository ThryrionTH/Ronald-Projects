package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.FormaPago;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.FormaPagoRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FormaPagoService extends BaseService<FormaPago> {

    private FormaPagoRepository repository;
    
      public FormaPagoService(FormaPagoRepository repository){
        super(repository);
        this.repository = repository;
    } 


    public Optional<FormaPago> findByDescripcion(String descrpcion) {
        return repository.findByDescripcion(descrpcion);
    }
}
