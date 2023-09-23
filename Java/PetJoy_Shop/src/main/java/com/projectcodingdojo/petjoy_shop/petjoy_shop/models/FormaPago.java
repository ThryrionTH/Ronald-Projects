package com.projectcodingdojo.petjoy_shop.petjoy_shop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "formas_pagos")
public class FormaPago extends BaseModel {

    @Column(name = "descripcion_forma_pago")
    private String descripcion;

    @OneToMany(mappedBy = "forma_pago", fetch = FetchType.LAZY)
    private List<Factura> facturas;
}
