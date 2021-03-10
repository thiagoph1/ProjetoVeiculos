package com.projeto.veiculos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.veiculos.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
	
	/* Pesquisar motoristas*/
	@Query("SELECT u, r FROM Usuario u JOIN u.roles r ")
	List<Usuario> findAllMotoristas();
}
