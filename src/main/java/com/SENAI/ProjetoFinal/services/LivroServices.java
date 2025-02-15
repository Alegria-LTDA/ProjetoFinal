package com.SENAI.ProjetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENAI.ProjetoFinal.entities.Editora;
import com.SENAI.ProjetoFinal.entities.Livro;
import com.SENAI.ProjetoFinal.exceptions.NaoEncontradoExceptions;
import com.SENAI.ProjetoFinal.repositories.EditoraRepository;
import com.SENAI.ProjetoFinal.repositories.LivroRepository;

import jakarta.transaction.Transactional;



@Service
public class LivroServices {

    
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	public List<Livro> procuraTodos() {
		return livroRepository.findAll();
	}

	public Livro procurarPorID(Integer id) {
		return livroRepository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Livro não encontrado."));
	}

	@Transactional
	public String adicionarLivro(Livro livro) {
		if(livro.getEditora() != null && livro.getEditora().getId() == null) {
			@SuppressWarnings("unused")
			Editora editora = editoraRepository.save(livro.getEditora());
		}
		livroRepository.save(livro);
		return "Livro adicionado com sucesso!";
	}

	public String editarLivro(Integer id, Livro livro) {
		Livro response = livroRepository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Livro não encontrado."));
		;

		response.setNome(livro.getNome());
		livroRepository.save(response);
		return "Livro editado com sucesso!";
	}

	public void excluirLivro(Integer id) {
		Livro response = livroRepository.findById(id).get();
		livroRepository.delete(response);
	}
}