package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Role;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.BaseRepository;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.RoleRepository;

@Service
public class RoleService extends BaseService<Role>{
    public RoleService(BaseRepository<Role> baseRepository) {
        super(baseRepository);
    }

    @Autowired RoleRepository roleRepository;

    public Role findByNameContaining(String name){
        return roleRepository.findByNameContaining(name);
    }

    public void saveAll(List<Role> roles){
        roleRepository.saveAll(roles);
    }
    
}
