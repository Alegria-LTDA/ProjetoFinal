package com.SENAI.ProjetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SENAI.ProjetoFinal.entities.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer> {

}