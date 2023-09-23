package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import org.springframework.stereotype.Repository;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Clients;

@Repository
public interface ClientsRepository extends BaseRepository<Clients> {
    Clients findByEmail(String email);
}

