package com.projectcodingdojo.petjoy_shop.petjoy_shop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Clients extends BaseModel {

    @NotNull
    @NotBlank(message = "El nombre no debe estar vacio")
    @Size(min = 3, max = 40, message = "El nombre debe tener minimo 3 caracteres")
    private String nombre;

    @NotNull
    @NotBlank(message = "El apellido no debe estar vacio")
    @Size(min = 3, max = 40, message = "El apellido debe tener minimo 3 caracteres")
    private String apellido;

    @NotNull
    @NotBlank(message = "El número de indentificación no debe estar vacio")
    @Size(min = 7, max = 13, message = "El número de identificación debe estar entre 7 y 13 digitos")
    private String nro_identificacion;

    @NotNull
    @NotBlank(message = "El email no deberia estar en blanco")
    @Email(message = "El formato del email no es el correcto")
    private String email;

    @NotNull
    @NotBlank(message = "La contraseña no debe estar vacia")
    @Size(min = 8, message = "La contraseña minimo debe tener 8 caracteres")
    private String contrasena;

    @Transient
    private String confirmarContrasena;

    @NotNull
    @Size(min = 9, max = 15, message = "El número del celular debe estar entre 9 y 15 digitos")
    private String celular;

    @NotNull
    @NotBlank(message = "La ciudad no debe estar vacia")
    @Size(max = 20, message = "La ciudad maximo debe tener 20 caracteres")
    private String ciudad;

    @NotNull
    @NotBlank(message = "El departamento no debe estar vacio")
    @Size(max = 20, message = "El departamento maximo debe tener 20 caracteres")
    private String departamento;

    @NotNull
    @NotBlank(message = "El dirección no debe estar vacio")
    @Size(max = 60, message = "La dirección maximo debe tener 60 caracteres")
    private String direccion;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas; 

    public Clients() {
    }

    public Clients(String nombre, String apellido, String email, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
    }

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "role_id")
    private Role role;

}
