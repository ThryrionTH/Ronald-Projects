package com.ronaldceballos.dojosandninjas.dojosandninjas.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Dojo;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Ninja;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Services.DojoService;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public NinjaController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja";
    }

    @RequestMapping(value = "/ninjas", method = RequestMethod.POST)
    public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Dojo> dojos = dojoService.getAllDojos();
            model.addAttribute("dojo", dojos);
            return "newNinja";
        }
        Dojo selectedDojo = dojoService.findDojo(ninja.getDojo().getId());
        ninja.setDojo(selectedDojo);
        ninjaService.createNinja(ninja);
        return "redirect:/";
    }
}
