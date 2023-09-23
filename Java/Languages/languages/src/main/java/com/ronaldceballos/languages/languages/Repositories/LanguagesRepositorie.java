package com.ronaldceballos.languages.languages.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronaldceballos.languages.languages.Models.LanguagesModel;

@Repository
public interface LanguagesRepositorie extends CrudRepository <LanguagesModel, Long> {
    List<LanguagesModel> findAll();
}
    
