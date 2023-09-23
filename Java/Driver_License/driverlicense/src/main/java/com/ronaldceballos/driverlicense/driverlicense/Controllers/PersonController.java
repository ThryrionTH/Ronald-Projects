package com.ronaldceballos.driverlicense.driverlicense.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.driverlicense.driverlicense.Models.Person;
import com.ronaldceballos.driverlicense.driverlicense.Services.PersonService;

import jakarta.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "newPerson";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "newPerson";
        }
        personService.createPerson(person);
        return "redirect:/";
    }
}
