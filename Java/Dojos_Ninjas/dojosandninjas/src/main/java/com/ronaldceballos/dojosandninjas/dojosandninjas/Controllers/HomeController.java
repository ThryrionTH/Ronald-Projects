package com.ronaldceballos.dojosandninjas.dojosandninjas.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ronaldceballos.dojosandninjas.dojosandninjas.Models.Dojo;
import com.ronaldceballos.dojosandninjas.dojosandninjas.Services.DojoService;

@Controller
public class HomeController {
    private final DojoService dojoService;

    public HomeController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();

        for (Dojo dojo : dojos) {
            dojo.setNinjaCount(dojo.getNinjas().size());
        }
        model.addAttribute("dojos", dojos);
        return "home";
    }

    @GetMapping("/dojos/{id}")
    public String showDojoDetails(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        if (dojo == null) {
            return "redirect:/"; 
        }
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", dojo.getNinjas());
        return "showDojo"; 
    }
}