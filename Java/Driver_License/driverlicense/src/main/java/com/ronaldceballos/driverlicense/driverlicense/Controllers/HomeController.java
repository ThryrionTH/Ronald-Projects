package com.ronaldceballos.driverlicense.driverlicense.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ronaldceballos.driverlicense.driverlicense.Models.License;
import com.ronaldceballos.driverlicense.driverlicense.Models.Person;
import com.ronaldceballos.driverlicense.driverlicense.Services.LicenseService;
import com.ronaldceballos.driverlicense.driverlicense.Services.PersonService;

@Controller
public class HomeController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public HomeController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Person> person = personService.getAllPersons();
        List<License> license = licenseService.getAllLicenses();
        List<Person> personsWithoutLicense = personService.getAllPersonsWithoutLicense();
        model.addAttribute("personsWithoutLicense", personsWithoutLicense);
        model.addAttribute("person", person);
        model.addAttribute("license", license);
        return "home";
    }

    @GetMapping("/persons/{id}")
    public String showPersonDetails(@PathVariable Long id, Model model) {
        Person person = personService.findPerson(id);
        if (person == null) {
            return "redirect:/"; 
        }
        model.addAttribute("person", person);
        model.addAttribute("license", person.getLicense());
        return "showPerson"; 
    }

}
