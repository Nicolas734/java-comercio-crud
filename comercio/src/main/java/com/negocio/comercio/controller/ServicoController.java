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
import com.negocio.comercio.model.Servico;
import com.negocio.comercio.repository.ComercioRepository;
import com.negocio.comercio.repository.ServicoRepository;

@RestController
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepo;
	@Autowired
	private ComercioRepository comercioRepo;
	
	@PostMapping("/servico")
	public Servico servico(@RequestBody Servico dados) {
		return dados;
	}
	
	@GetMapping("/searchServico")
	public Iterable<Servico> searchAllServico(){
		return servicoRepo.findAll();
	}
	
	@PostMapping("/criarServico/{id}")
	public Servico createServico(@RequestBody Servico dados, @PathVariable Long id) {
		Comercio comercio = comercioRepo.findById(id).get();
		dados.setComercio(comercio);
		servicoRepo.save(dados);
		return dados;
	}
	
	@PutMapping("/updateServico/{id}")
	public Servico updateServico(@RequestBody Servico dados, @PathVariable Long id) {
		Servico servico = servicoRepo.findById(id).get();
		if(dados.getNome() != null) {
			servico.setNome(dados.getNome());
		}
		if(dados.getDescricao() != null) {
			servico.setDescricao(dados.getDescricao());
		}
		if(dados.getPreco() != null) {
			servico.setPreco(dados.getPreco());
		}
		return servicoRepo.save(servico);
	}
	
	@DeleteMapping("/deleteServico/{id}")
	public ResponseEntity<Void> deleteServico(@PathVariable Long id){
		Servico servico = servicoRepo.findById(id).get();
		servicoRepo.delete(servico);
		return ResponseEntity.noContent().build();
	}
}
