package com.ronaldceballos.liststudents.liststudents.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.liststudents.liststudents.Models.Dorm;
import com.ronaldceballos.liststudents.liststudents.Repsositories.DormRepository;

@Service
public class DormService {
    private final DormRepository dormRepository;

    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    public List<Dorm> getAllDorms() {
        return dormRepository.findAll();
    }

    public Dorm createDorm(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if (optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }

    public void deleteDorm(Long id) {
        dormRepository.deleteById(id);
    }
}
