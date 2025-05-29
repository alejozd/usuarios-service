package com.alejo.usuariosservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    private LocalDateTime creadoEn = LocalDateTime.now();

    // Getters y setters
}