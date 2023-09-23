package com.codingdojo.hi_human.hi_human;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/your_server")
public class HumanController {

    @GetMapping("")
    public String hello(@RequestParam(value = "first_name", defaultValue = "Human") String firstName,
            @RequestParam(value = "last_name", defaultValue = "") String lastName) {
        String hello = "Hello " + firstName + " " + lastName;
        String welcome = "Welcome to SpringBoot!";
        return "<h1>" + hello + "</h1><p>" + welcome + "</p>";
    }
}
