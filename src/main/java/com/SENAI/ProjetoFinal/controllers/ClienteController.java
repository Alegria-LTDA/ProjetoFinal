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
import com.SENAI.ProjetoFinal.entities.Cliente;
import com.SENAI.ProjetoFinal.services.ClienteServices;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteServices service;

	@GetMapping
	public ResponseEntity<List<Cliente>> procuraTodos() {
		List<Cliente> ListaDeClientes = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(ListaDeClientes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> procurarPorId(@PathVariable Integer id) {
		Cliente response = service.procurarPorID(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente) {
		String response = service.adicionarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		String response = service.editarCliente(id, cliente);
		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Integer id) {
		service.excluirCliente(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}