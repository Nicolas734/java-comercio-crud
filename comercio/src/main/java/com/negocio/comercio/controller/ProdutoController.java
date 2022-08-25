package com.negocio.comercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.negocio.comercio.model.Comercio;
import com.negocio.comercio.model.Produto;
import com.negocio.comercio.repository.ComercioRepository;
import com.negocio.comercio.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private ComercioRepository comercioRepo;
	
	@PostMapping("/produto")
	public Produto produto(@RequestBody Produto dados) {
		return dados;
	}
	
	@GetMapping("/searchProduto")
	public Iterable<Produto> searchAllProduto() {
		return produtoRepo.findAll();
	}
	
	@GetMapping("/searchProdById/{id}")
	public Produto searchProdutoById(@PathVariable Long id) {
		return produtoRepo.findById(id).get();
	}
	
	@PostMapping("/criarProduto/{id}")
	public Produto createProduto(@RequestBody Produto dados, @PathVariable Long id) {
		Comercio comercio = comercioRepo.findById(id).get();
		dados.setComercio(comercio);
		produtoRepo.save(dados);
		return dados;
	}
	
	@PutMapping("/updateProduto/{id}")
	public Produto updateProduto(@RequestBody Produto dados, @PathVariable Long id) {
		Produto produto = produtoRepo.findById(id).get();
		if(dados.getNome() != null) {	
			produto.setNome(dados.getNome());
		}
		if(dados.getDescricao() != null) {			
			produto.setDescricao(dados.getDescricao());
		}
		if(dados.getPreco() != null) {			
			produto.setPreco(dados.getPreco());
		}
		return produtoRepo.save(produto);
	}
	
	@DeleteMapping("/deleteProduto/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
		Produto produto = produtoRepo.findById(id).get();
		produtoRepo.delete(produto);
		return ResponseEntity.noContent().build();
		
	}
	
}
