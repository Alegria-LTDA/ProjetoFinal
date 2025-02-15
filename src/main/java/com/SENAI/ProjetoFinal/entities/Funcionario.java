package com.SENAI.ProjetoFinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cargo;
	@Column(unique = true, nullable = false)
	private Long salario;
	@Column(unique = true, length = 10, nullable = false)
	private Long CPF;

	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String cargo, Long salario, Long CPF) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

}