package com.alejo.usuariosservice.repository;

import com.alejo.usuariosservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
