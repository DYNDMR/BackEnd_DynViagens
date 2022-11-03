package com.br.dyn.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.dyn.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);

}
