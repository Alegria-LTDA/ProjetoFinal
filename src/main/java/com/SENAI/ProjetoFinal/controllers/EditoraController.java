package com.SENAI.ProjetoFinal.controllers;

import java.util.List;

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

import com.SENAI.ProjetoFinal.entities.Editora;
import com.SENAI.ProjetoFinal.services.EditoraServices;

@RestController
@RequestMapping(value = "/editora")
public class EditoraController {

	@Autowired
	private EditoraServices service;

	@GetMapping
	public ResponseEntity<List<Editora>> procuraTodos() {
		List<Editora> ListaDeEditoras = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(ListaDeEditoras);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Editora> procurarPorId(@PathVariable Integer id) {
		Editora response = service.procurarPorID(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	public ResponseEntity<String> adicionarEditora(@RequestBody Editora editora) {
		String response = service.adicionarEditora(editora);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarEditora(@PathVariable Integer id, @RequestBody Editora editora) {
		String response = service.editarEditora(id, editora);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirEditora(@PathVariable Integer id) {
		service.excluirEditora(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}