package com.codingdojo.ninjagold.ninjagold;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@ComponentScan
public class NinjaController {

    private int gold = 0;
    private int prision = -100;
    private List<String> activities = new ArrayList<>();

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("ninja", new Ninja(gold));
        model.addAttribute("activities", activities);
            
        if (gold <= prision) {
            return "morosos";
        }
        return "index";
    }

    @PostMapping("/farm")
    public String farm() {
        int randomGold = getRandomNumber(10, 20);
        gold += randomGold;
        String activity = "Your entered a Farm and earned " + randomGold + " gold (" + new Date() + ")";
        activities.add(activity);
        return "redirect:/";
    }

    @PostMapping("/cave")
    public String cave() {
        int randomGold = getRandomNumber(5, 10);
        gold += randomGold;
        String activity = "Your entered a Cave and earned " + randomGold + " gold (" + new Date() + ")";
        activities.add(activity);
        return "redirect:/";
    }

    @PostMapping("/house")
    public String house() {
        int randomGold = getRandomNumber(2, 5);
        gold += randomGold;
        String activity = "Your entered a House and earned " + randomGold + " gold (" + new Date() + ")";
        activities.add(activity);
        return "redirect:/";
    }

    @PostMapping("/casino")
    public String casino() {
        int randomGold = getRandomNumber(0, 50);
        boolean winorlost = new Random().nextBoolean();
        if (winorlost == true) {
            gold += randomGold;
            String activity = "Your entered a Casino and earned " + randomGold + " gold (" + new Date() + ")";
            activities.add(activity);
        } else {
            gold -= randomGold;
            String activity = "Your entered a Casino and lost " + randomGold + " gold (" + new Date() + ")";
            activities.add(activity);
        }
        return "redirect:/";
    }

    @PostMapping("/spa")
    public String spa() {
        int randomGold = getRandomNumber(-20, -5);
        gold += randomGold;
        String activity = "Your entered a Spa and lost " + randomGold + " gold (" + new Date() + ")";
        activities.add(activity);
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        gold = 0;
        activities.clear();
        return "redirect:/";
    }

    private int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
