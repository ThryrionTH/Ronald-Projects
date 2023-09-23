package com.ronaldceballos.driverlicense.driverlicense.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.driverlicense.driverlicense.Models.License;

public interface LicenseRepository extends CrudRepository <License, Long> {
    List<License> findAll();
    @Query("SELECT MAX(CAST(l.number AS integer)) FROM License l")
    Integer findMaxLicenseNumber();
}
