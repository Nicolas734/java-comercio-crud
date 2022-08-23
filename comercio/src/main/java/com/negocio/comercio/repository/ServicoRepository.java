package com.negocio.comercio.repository;

import org.springframework.data.repository.CrudRepository;

import com.negocio.comercio.model.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Long> {
	
}
