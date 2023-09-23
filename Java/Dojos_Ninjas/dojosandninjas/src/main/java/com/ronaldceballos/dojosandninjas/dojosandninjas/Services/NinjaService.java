package com.ronaldceballos.dojosandninjas.dojosandninjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Ninja;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja Ninja) {
        return ninjaRepository.save(Ninja);
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
}
