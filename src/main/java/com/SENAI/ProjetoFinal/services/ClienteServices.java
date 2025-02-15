package com.SENAI.ProjetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENAI.ProjetoFinal.entities.Cliente;
import com.SENAI.ProjetoFinal.exceptions.NaoEncontradoExceptions;
import com.SENAI.ProjetoFinal.repositories.ClienteRepository;


@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> procuraTodos() {
		return repository.findAll();
	}

	public Cliente procurarPorID(Integer id) {
		return repository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Cliente não encontrado."));
	}

	public String adicionarCliente(Cliente cliente) {
		repository.save(cliente);
		return "Usuário adicionado com sucesso!";
	}

	public String editarCliente(Integer id, Cliente cliente) {
		Cliente response = repository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Usuário não encontrado."));
		;

		response.setNome(cliente.getNome());
		response.setEmail(cliente.getEmail());
		response.setSenha(cliente.getSenha());
		response.setCPF(cliente.getCPF());

		repository.save(response);
		return "Cliente editado com sucesso!";
	}

	public void excluirCliente(Integer id) {
		Cliente response = repository.findById(id).get();
		repository.delete(response);
	}
}