package br.atos.petshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.petshop.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUserName(String userName);
}
