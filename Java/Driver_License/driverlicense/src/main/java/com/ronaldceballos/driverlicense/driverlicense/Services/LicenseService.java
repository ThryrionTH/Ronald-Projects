package com.ronaldceballos.driverlicense.driverlicense.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.driverlicense.driverlicense.Models.License;
import com.ronaldceballos.driverlicense.driverlicense.Repositories.LicenseRepository;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if (optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

    public int getNextLicenseNumber() {
        Integer maxLicenseNumber = licenseRepository.findMaxLicenseNumber();
        if (maxLicenseNumber == null) {
            return 1;
        }
        return maxLicenseNumber + 1;
    }
    
    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }
}
