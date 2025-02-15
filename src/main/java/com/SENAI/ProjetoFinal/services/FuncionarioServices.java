package com.SENAI.ProjetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SENAI.ProjetoFinal.entities.Funcionario;
import com.SENAI.ProjetoFinal.exceptions.NaoEncontradoExceptions;
import com.SENAI.ProjetoFinal.repositories.FuncionarioRepository;


@Service
public class FuncionarioServices {

    
	@Autowired
	private FuncionarioRepository funcionariorepository;

	public List<Funcionario> procuraTodos() {
		return funcionariorepository.findAll();
	}

	public Funcionario procurarPorID(Integer id) {
		return funcionariorepository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Funcionario não encontrado."));
	}

	public String adicionarFuncionario(Funcionario funcionario) {
		funcionariorepository.save(funcionario);
		return "Funcionario adicionado com sucesso!";
	}

	public String editarFuncionario(Integer id, Funcionario funcionario) {
		Funcionario response = funcionariorepository.findById(id).orElseThrow(() -> new NaoEncontradoExceptions("Funcionario não encontrado."));
		;

		response.setNome(funcionario.getNome());
		response.setCPF(funcionario.getCPF());
		response.setCargo(funcionario.getCargo());
		response.setSalario(funcionario.getSalario());

		funcionariorepository.save(response);
		return "Funcionario editado com sucesso!";
	}

	public void excluirFuncionario(Integer id) {
		Funcionario response = funcionariorepository.findById(id).get();
		funcionariorepository.delete(response);
	}
}