package com.SENAI.ProjetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SENAI.ProjetoFinal.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}