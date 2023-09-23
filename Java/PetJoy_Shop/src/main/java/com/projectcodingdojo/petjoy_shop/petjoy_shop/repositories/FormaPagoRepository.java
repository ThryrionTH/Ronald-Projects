package com.projectcodingdojo.petjoy_shop.petjoy_shop.repositories;

import com.projectcodingdojo.petjoy_shop.petjoy_shop.models.FormaPago;
import java.util.Optional;

public interface FormaPagoRepository extends BaseRepository<FormaPago> {

    Optional<FormaPago> findByDescripcion(String descrpcion);
}
