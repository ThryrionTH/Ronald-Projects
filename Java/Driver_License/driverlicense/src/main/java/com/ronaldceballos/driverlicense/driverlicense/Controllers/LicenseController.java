package com.ronaldceballos.driverlicense.driverlicense.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ronaldceballos.driverlicense.driverlicense.Models.License;
import com.ronaldceballos.driverlicense.driverlicense.Models.Person;
import com.ronaldceballos.driverlicense.driverlicense.Services.LicenseService;
import com.ronaldceballos.driverlicense.driverlicense.Services.PersonService;

import jakarta.validation.Valid;

@Controller
public class LicenseController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public LicenseController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @GetMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
        List<Person> personsWithoutLicense = personService.getAllPersonsWithoutLicense();
        model.addAttribute("personsWithoutLicense", personsWithoutLicense);
        return "newLicense";
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Person> personsWithoutLicense = personService.getAllPersonsWithoutLicense();
            model.addAttribute("personsWithoutLicense", personsWithoutLicense);
            return "newLicense";
        }
        Person selectedPerson = personService.findPerson(license.getPerson().getId());
        String licenseNumber = String.format("%06d", licenseService.getNextLicenseNumber());
        License newLicense = new License(licenseNumber, license.getExpirationDate(), license.getState());
        newLicense.setPerson(selectedPerson);
        licenseService.createLicense(newLicense);
        return "redirect:/";
    }
}
