package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;


import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Role;


public interface RoleRepository extends BaseRepository<Role> {
    Role findByNameContaining(String name);
}
