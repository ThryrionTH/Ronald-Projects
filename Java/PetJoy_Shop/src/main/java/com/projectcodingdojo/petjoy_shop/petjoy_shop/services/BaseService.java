package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.List;
import java.util.Optional;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.BaseRepository;
import jakarta.transaction.Transactional;

public abstract class BaseService<T> {

    private BaseRepository<T> baseRepository;

    public BaseService(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public List<T> findActive() {
        return baseRepository.findByActive(1);
    }

    @Transactional
    public T save(T object) {
        return baseRepository.save(object);
    }

    public T findById(Long id) {
        Optional<T> optional = baseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public T update(T object) {
        return save(object);
    }

    public T delete(T objeto) {
        baseRepository.delete(objeto);
        return objeto;
    }

}
