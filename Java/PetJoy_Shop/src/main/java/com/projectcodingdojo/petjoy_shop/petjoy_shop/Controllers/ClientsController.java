package com.projectcodingdojo.petjoy_shop.petjoy_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Clients;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Role;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.security.DetallesSeguridadUsuario;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ClientsService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.RoleService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ClientsController {

    @Value("${role_user}")
    private String USER_ROLE;

    @Autowired
    ClientsService clientsService;
    @Autowired
    RoleService roleService;
    @Autowired
    DetallesSeguridadUsuario securityUserDetails;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("client", new Clients());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginClients(@ModelAttribute("client") Clients client, Model model, HttpSession session) {
        String email = client.getEmail();
        Clients authClients = clientsService.findByEmail(email);
        session.setAttribute("client", authClients.getId());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String registerForm(@ModelAttribute("client") Clients client) {
        return "signup";
    }

    @RequestMapping(value = "/dash/edit/user", method = RequestMethod.PUT)
    public String updateClients(@Valid @ModelAttribute("client") Clients client, @RequestParam("id") Long clientId, BindingResult result) {
    System.out.println(clientId);

    if (result.hasErrors()) {
        System.out.println("error de validación");
        return "dashClient";
    }

    Clients existingClients = clientsService.findById(clientId);
    if (existingClients == null) {
        return "redirect:/dashClient";
    }

    existingClients.setNombre(client.getNombre());
    existingClients.setApellido(client.getApellido());
    existingClients.setCelular(client.getCelular());
    existingClients.setCiudad(client.getCiudad());
    existingClients.setDepartamento(client.getDepartamento());
    existingClients.setDireccion(client.getDireccion());
    existingClients.setEmail(client.getEmail());
    existingClients.setContrasena(client.getContrasena());

    clientsService.save(existingClients);
    return "redirect:/logout";
}


    @RequestMapping("/checkout")
    public String clientCheckout(HttpSession session, Model model) {

        if (session.getAttribute("cliente") == null) {
            return "redirect:/login";
        }
        Clients client = (Clients) session.getAttribute("cliente");
        model.addAttribute("client", client);
        return "checkout_cart";
    }

    @PostMapping("/signup")
    public String registerClients(
            @Valid @ModelAttribute("client") Clients client, BindingResult result, HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "signup";
        }

        Clients existingClient = clientsService.findByEmail(client.getEmail());
        if (existingClient != null) {
            result.rejectValue("email", "error.client", "El email ya se encuentra en uso");
            return "signup";
        }

        if (!client.getContrasena().equals(client.getConfirmarContrasena())) {
            result.rejectValue("confirmarContrasena", "error.client", "Las contraseñas no son iguales");
            return "signup";
        }

        Clients newClient = clientsService.save(client);

        Role role = roleService.findByNameContaining(USER_ROLE);
        client.setRole(role);

        String encodePassword = securityUserDetails.bCryptPasswordEncoder().encode(client.getContrasena());
        client.setContrasena(encodePassword);
        clientsService.save(client);

        session.setAttribute("client_name", newClient.getNombre());
        session.setAttribute("client_apellido", newClient.getApellido());
        session.setAttribute("client_id", newClient.getId());

        session.setAttribute("cliente", client);

        return "redirect:/";
    }

}
