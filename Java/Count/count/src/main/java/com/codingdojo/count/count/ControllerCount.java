package com.codingdojo.count.count;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerCount {
    
    @RequestMapping("/")
    public String index(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        session.setAttribute("count", count + 1);

        Integer count2 = (Integer) session.getAttribute("count2");
        if (count2 == null) {
            count2 = 0;
        }
        session.setAttribute("count2", count2 + 2);

        return "index";
    }

    @GetMapping("/counter")
    public String count(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        model.addAttribute("count", count);
        return "counter";
    }

    @GetMapping("/counter2")
    public String count2(HttpSession session, Model model) {
        Integer count2 = (Integer) session.getAttribute("count2");
        model.addAttribute("count2", count2);
        return "counter2";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.removeAttribute("count");
        session.removeAttribute("count2");
        return "index";
    }

}
