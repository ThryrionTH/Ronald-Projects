package com.ronaldceballos.dojosandninjas.dojosandninjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}
