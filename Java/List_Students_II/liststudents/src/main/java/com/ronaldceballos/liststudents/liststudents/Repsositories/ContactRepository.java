package com.ronaldceballos.liststudents.liststudents.Repsositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.liststudents.liststudents.Models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAll();
}
