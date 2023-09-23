package com.projectcodingdojo.petjoy_shop.petjoy_shop.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marcas_productos")

@Getter @Setter @NoArgsConstructor

public class ProductBrand extends BaseModel{
    
    @NotBlank
    @NotNull
    @Column(name = "nombre_marca")
    private String nombremarca;

    @OneToMany(mappedBy = "marca_producto", fetch = FetchType.LAZY)
    private List<Product> products;

}
