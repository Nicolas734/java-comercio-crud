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
import com.negocio.comercio.model.Endereco;
import com.negocio.comercio.repository.ComercioRepository;
import com.negocio.comercio.repository.EnderecoRepository;

@RestController
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private ComercioRepository comercioRepo;
	
	@PostMapping("/endereco")
	public Endereco endereco(@RequestBody Endereco dados) {
		return dados;
	}
	
	@GetMapping("/searchEndereco")
	public Iterable<Endereco> searchEndereco(){
		return enderecoRepo.findAll();
	}
	
	@PostMapping("/criarEndereco/{id}")
	public Endereco createEndereco(@RequestBody Endereco dados, @PathVariable Long id) {
		Comercio comercio = comercioRepo.findById(id).get();
		if(comercio.getEndereco() != null) {
			return null;
		}
		dados.setComercio(comercio);
		return enderecoRepo.save(dados);
	}
	
	@PutMapping("/updateEndereco/{id}")
	public Endereco updateEndereco(@RequestBody Endereco dados, @PathVariable Long id) {
		Endereco endereco = enderecoRepo.findById(id).get();
		if(dados.getEstado() != null) {
			endereco.setEstado(dados.getEstado());
		}
		if(dados.getCidade() != null) {
			endereco.setCidade(dados.getCidade());
		}
		if(dados.getCep() != null) {
			endereco.setCep(dados.getCep());
		}
		if(dados.getBairro() != null) {
			endereco.setBairro(dados.getBairro());
		}
		if(dados.getRua() != null) {
			endereco.setRua(dados.getRua());
		}
		if(dados.getNumero() != null) {
			endereco.setNumero(dados.getNumero());
		}
		return enderecoRepo.save(endereco);
	}
	
	@DeleteMapping("/deleteEndereco/{id}")
	public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
		Comercio comercio = comercioRepo.findById(id).get();
		enderecoRepo.delete(comercio.getEndereco());
		return ResponseEntity.noContent().build();
	}
	
}
