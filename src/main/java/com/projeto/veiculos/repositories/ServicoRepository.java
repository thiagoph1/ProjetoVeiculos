package com.projeto.veiculos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.veiculos.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	
	
}
