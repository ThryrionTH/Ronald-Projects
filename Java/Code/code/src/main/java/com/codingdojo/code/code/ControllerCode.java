package com.codingdojo.code.code;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerCode {
    @RequestMapping("/") 
    public String index(Model model) {
        model.addAttribute("code", "");
        return "home";
    }

    @PostMapping("/checkcode")
    public String checkCode(String code, RedirectAttributes redirectAttributes) {
        if (code.equals("bushido")) {
            return "redirect:/code";
        } else {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }
    }

    @RequestMapping("/code")
    public String code(RedirectAttributes redirectAttributes) {
        return "code";
    }
}
