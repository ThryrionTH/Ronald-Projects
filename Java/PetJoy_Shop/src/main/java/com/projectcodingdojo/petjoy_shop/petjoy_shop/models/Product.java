package com.projectcodingdojo.petjoy_shop.petjoy_shop.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productos")

@Getter @Setter @NoArgsConstructor

public class Product extends BaseModel{   

    @NotNull
    @NotBlank(message = "El campo 'nombre' no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener de 1 a 50 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 20, message = "El código debe tener de 1 a 20 caracteres")
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "imagen")
    private String imagen;

    @Transient
    private MultipartFile imagenFile;

    @NotNull
    @Min(value = 1, message = "El precio debe tener un valor mayor a 0")
    @Column(name = "precio")
    private double precio;

    @NotNull
    @NotBlank(message = "El campo 'descripción' no puede estar vacío")
    @Size(min = 1, max = 500, message = "la descripción debe tener de 1 a 500 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    @Column(name = "stock")
    private int stock;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_elaboracion")
    private Date fechaElaboracion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_producto_id")
    private ProductBrand marca_producto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_animal_id")
    private ProductAnimal producto_animal;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_producto_id")
    private ProductType tipo_producto;

    
    public void DisminuirStock(int cantidad){
        this.stock = this.stock - cantidad;
    }
}