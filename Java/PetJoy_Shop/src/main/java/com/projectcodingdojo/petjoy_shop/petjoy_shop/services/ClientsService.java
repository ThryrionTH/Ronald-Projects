package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Clients;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.BaseRepository;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.ClientsRepository;

@Service
public class ClientsService extends BaseService<Clients> {
    public ClientsService(BaseRepository<Clients> baseRepository) {
        super(baseRepository);
    }

    @Autowired ClientsRepository clientsRepository ;
    public Clients findByEmail(String email) {
        return clientsRepository.findByEmail(email);
    }

}
