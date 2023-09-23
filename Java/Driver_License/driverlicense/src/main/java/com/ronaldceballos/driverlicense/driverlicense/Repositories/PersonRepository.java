package com.ronaldceballos.driverlicense.driverlicense.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.driverlicense.driverlicense.Models.Person;

public interface PersonRepository extends CrudRepository <Person, Long> {
    List<Person> findAll();
    List<Person> findByLicenseIsNull();
}
