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
import com.SENAI.ProjetoFinal.entities.Funcionario;
import com.SENAI.ProjetoFinal.services.FuncionarioServices;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioServices service;

	@GetMapping
	public ResponseEntity<List<Funcionario>> procuraTodos() {
		List<Funcionario> ListaDeFuncionarios = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(ListaDeFuncionarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> procurarPorId(@PathVariable Integer id) {
		Funcionario response = service.procurarPorID(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	public ResponseEntity<String> adicionarFuncionario(@RequestBody Funcionario funcionario) {
		String response = service.adicionarFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
		String response = service.editarFuncionario(id, funcionario);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirLivro(@PathVariable Integer id) {
		service.excluirFuncionario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}