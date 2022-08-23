package com.negocio.comercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.negocio.comercio.model.Comercio;
import com.negocio.comercio.repository.ComercioRepository;


@RestController
public class ComercioController {
	
	@Autowired
	private ComercioRepository comercioRepo;
	
	@PostMapping("/comercio")
	public Comercio SetDadosComercio(@RequestBody Comercio dados) {
		Comercio comercio = dados;
		return comercio;
	}
	
	@PostMapping("/criar")
	public Comercio createComercio(@RequestBody Comercio dados) {
		comercioRepo.save(dados);
		return dados;
	}
	
	@GetMapping("/search")
	public Iterable<Comercio> searchAllComercio() {
		return comercioRepo.findAll();
	}
	
	@PutMapping("/updateComercio/{id}")
	public Comercio updateComercio(@RequestBody Comercio dados, @PathVariable Long id) {
		Comercio comercio = comercioRepo.findById(id).get();
		if(dados.getNome() != null) {
			comercio.setNome(dados.getNome());
		}
		if(dados.getEmail() != null) {			
			comercio.setEmail(dados.getEmail());
		}
		if(dados.getCnpj() != null) {			
			comercio.setCnpj(dados.getCnpj());
		}
		if(dados.getTell() != null) {			
			comercio.setTell(dados.getTell());
		}
		
		return comercioRepo.save(comercio);
	}
	
	@DeleteMapping("/deleteComercio/{id}")
	public ResponseEntity<Void> deleteComercio(@PathVariable Long id) {
		Comercio comercio = comercioRepo.findById(id).get();
		comercioRepo.delete(comercio);
		return ResponseEntity.noContent().build();
		
	}
}
