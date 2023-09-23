
package com.projectcodingdojo.petjoy_shop.petjoy_shop.services;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.Pedido;
import com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepo;
    
    @Transactional
    public void Save(Pedido obj){
        pedidoRepo.save(obj);
    }
}
