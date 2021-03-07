package com.projeto.veiculos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.veiculos.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}
