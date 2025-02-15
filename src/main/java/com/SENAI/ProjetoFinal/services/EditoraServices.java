package com.SENAI.ProjetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENAI.ProjetoFinal.entities.Editora;
import com.SENAI.ProjetoFinal.exceptions.NaoEncontradoExceptions;
import com.SENAI.ProjetoFinal.repositories.EditoraRepository;

@Service
public class EditoraServices {

    
	@Autowired
	private EditoraRepository repository;

	public List<Editora> procuraTodos() {
		return repository.findAll();
	}

	public Editora procurarPorID(Integer id) {
		return repository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Editora não encontrado."));
	}

	public String adicionarEditora(Editora editora) {
		repository.save(editora);
		return "Editora adicionada com sucesso!";
	}

	public String editarEditora(Integer id, Editora editora) {
		Editora response = repository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Editora não encontrado."));
		;

		response.setNome(editora.getNome());

		repository.save(response);
		return "Editora editada com sucesso!";
	}

	public void excluirEditora(Integer id) {
		Editora response = repository.findById(id).get();
		repository.delete(response);
	}
}