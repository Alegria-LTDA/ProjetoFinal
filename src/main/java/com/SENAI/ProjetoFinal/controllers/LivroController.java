package com.SENAI.ProjetoFinal.controllers;

import java.util.List;
//Imports do Springboot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Imports das minhas listas
import com.SENAI.ProjetoFinal.entities.Livro;
import com.SENAI.ProjetoFinal.services.LivroServices;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

	@Autowired
	private LivroServices service;

	@GetMapping
	public ResponseEntity<List<Livro>> procuraTodos() {
		List<Livro> ListaDeLivros = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(ListaDeLivros);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> procurarPorId(@PathVariable Integer id) {
		Livro response = service.procurarPorID(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	public ResponseEntity<String> adicionarLivro(@RequestBody Livro livro) {
		String response = service.adicionarLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
		String response = service.editarLivro(id, livro);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirLivro(@PathVariable Integer id) {
		service.excluirLivro(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}