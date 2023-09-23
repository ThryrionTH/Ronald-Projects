package com.ronaldceballos.liststudents.liststudents.Repsositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.liststudents.liststudents.Models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
    List<Student> findAll();
    List<Student> findByContactIsNull();
}
