package com.ronaldceballos.dojosandninjas.dojosandninjas.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Dojo;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo";
    }

    @RequestMapping(value = "/dojos", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo";
        }
        dojoService.createDojo(dojo);
        return "redirect:/";
    }
}
