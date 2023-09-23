package com.ronaldceballos.dojosandninjas.dojosandninjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
