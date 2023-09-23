package com.ronaldceballos.dojosandninjas.dojosandninjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Dojo;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo Dojo) {
        return dojoRepository.save(Dojo);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
