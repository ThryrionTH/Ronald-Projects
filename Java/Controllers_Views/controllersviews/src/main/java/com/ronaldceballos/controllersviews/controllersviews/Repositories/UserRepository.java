package com.ronaldceballos.controllersviews.controllersviews.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronaldceballos.controllersviews.controllersviews.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}

