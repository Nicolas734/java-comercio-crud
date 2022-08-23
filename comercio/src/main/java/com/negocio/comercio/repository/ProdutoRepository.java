package com.negocio.comercio.repository;

import org.springframework.data.repository.CrudRepository;

import com.negocio.comercio.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
