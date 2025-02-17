package com.SENAI.ProjetoFinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column
	private String genero;
	@Column
	private String sinopse;
	@Column
	private Integer ano;

	public Livro() {
	}

	@ManyToOne
	@JoinColumn(name = "editora_id", nullable = true)
	public Editora editora;

	public Livro(Integer id, String nome, String genero, String sinopse, Integer ano, Editora editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.sinopse = sinopse;
		this.ano = ano;
		this.editora = editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Integer getId() {
		return id;
	}

}