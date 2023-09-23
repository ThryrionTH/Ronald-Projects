package com.projectcodingdojo.petjoy_shop.petjoy_shop.seed;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Clients;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Role;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.security.DetallesSeguridadUsuario;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.ClientsService;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.services.RoleService;

@Component
public class Seed implements ApplicationRunner{


    @Value("${role_user}")
    private String USER; 
    @Value("${role_admin}")
    private String ADMIN; 

    private String prefix = "ROLE_";


    @Autowired RoleService roleService;
    @Autowired ClientsService clientsService;
    @Autowired DetallesSeguridadUsuario securityUserDetails;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Role> roles = roleService.findAll();
        if(roles.isEmpty()){
            createRoles();
        }

        List<Clients> clients = clientsService.findAll();
         if(clients.isEmpty()){
            createAdmin();
        }
    }
    private void createAdmin() {
        Clients clients = new Clients();
        clients.setNombre("Sara");
        clients.setApellido("Ramos");
        clients.setEmail("sara@gmail.com");
        clients.setCelular("3228066211");
        clients.setNro_identificacion("ldslñ3833");
        clients.setCiudad("Boogota");
        clients.setDireccion("carrera 100");
        clients.setDepartamento("cundinamarca");
    

        Role role = roleService.findByNameContaining(ADMIN);
        clients.setRole(role);

        String encodePassword = securityUserDetails.bCryptPasswordEncoder().encode("123456789");
        clients.setContrasena(encodePassword);
        clientsService.save(clients);
        
    }
    private void createRoles() {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName(prefix + USER);
        roles.add(role);

        role = new Role();
        role.setName(prefix + ADMIN);
        roles.add(role);

        roleService.saveAll(roles);
    }
    
}
