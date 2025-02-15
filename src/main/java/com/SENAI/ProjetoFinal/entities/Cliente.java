package com.SENAI.ProjetoFinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(length = 40, nullable = false)
	private String senha;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, length = 10, nullable = false)
	private Long CPF;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String senha, String email, Long CPF) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.CPF = CPF;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long CPF) {
		this.CPF = CPF;
	}

}