package com.negocio.comercio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Comercio {
	
	//private static final long serialVersionUID = 1507218635788384719L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String nome;
	@Column
	private String cnpj;
	@Column
	private String email;
	@Column
	private String tell;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "comercio", fetch = FetchType.EAGER)
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "comercio", fetch = FetchType.LAZY)
	private List<Servico> servicos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "comercio", fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
