package com.codingdojo.surveydojo.surveydojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

    @GetMapping("/")
    public String home(){
        return"index";
    }

    @PostMapping("/result")
    public String result(@RequestParam("name") String name, @RequestParam("dojoLocation") String dojoLocation,
    @RequestParam("favoriteLanguage") String favoriteLanguage, @RequestParam(value = "description", required = false) String description, Model model) {

        if (description == null || description.isEmpty()) {
            description = "Hi there :)";
        }
        
        model.addAttribute("name", name);
        model.addAttribute("dojoLocation", dojoLocation);
        model.addAttribute("favoriteLanguage", favoriteLanguage);
        model.addAttribute("description", description);
        return"result";
    }
}
