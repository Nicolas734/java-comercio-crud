package com.negocio.comercio.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.negocio.comercio.model.Comercio;



public interface ComercioRepository extends CrudRepository<Comercio, Long>{
	//public List<Comercio> findByNome(String nome);
}
