package com.projeto.veiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.veiculos.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query("select r from Role r where r.nomeRole like ?1")
	Role findByName(String nomeRole);
	
}
