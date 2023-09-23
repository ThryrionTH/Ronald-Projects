package com.projectcodingdojo.petjoy_shop.petjoy_shop.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Clients;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ClientsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Value("${role_admin}")
    private String ROLE_ADMIN;
    @Autowired
    ClientsService clientsService;

    @GetMapping("/user")
    public String user(Principal principal, HttpSession session) {
        String usuario = principal.getName();
        Clients existingClient = clientsService.findByEmail(usuario);

        session.setAttribute("cliente", existingClient);

        if (existingClient.getRole().getName().contentEquals("ROLE_ADMIN")) {
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

    @GetMapping("/dash/edit")
    @Secured("ROLE_USER") 
    public String editProfile(Model model, HttpSession session) {
        Clients currentUser = (Clients) session.getAttribute("cliente");

        if (currentUser == null) {
            return "redirect:/login";
        }

        Clients client = clientsService.findById(currentUser.getId());

        if (client == null) {
            return "redirect:/"; 
        }

        model.addAttribute("client", client);

        return "dashClient"; 
    }

}
