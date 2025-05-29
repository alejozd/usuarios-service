package com.alejo.usuariosservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email no es válido")
    private String email;

    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creado_en = LocalDateTime.now();

    // Getters y setters
    // Constructor vacío (requerido por JPA)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.creado_en = LocalDateTime.now();  // lo inicializamos aquí
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(LocalDateTime creado_en) {
        this.creado_en = creado_en;
    }

    // Evento que se ejecuta justo antes de insertar el dato
    @PrePersist
    protected void onCreate() {
        this.creado_en = LocalDateTime.now();
    }
}