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
@Table (name = "producto_animal")

@Getter @Setter @NoArgsConstructor

public class ProductAnimal extends BaseModel{
    
    @NotNull
    @NotBlank
    @Column(name = "animal")
    private String animal;

    @OneToMany(mappedBy = "producto_animal", fetch = FetchType.LAZY)
    private List<Product> products;

}
