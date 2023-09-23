package com.ronaldceballos.liststudents.liststudents.Repsositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.liststudents.liststudents.Models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}
