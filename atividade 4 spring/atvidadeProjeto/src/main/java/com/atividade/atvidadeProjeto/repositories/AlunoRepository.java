package com.atividade.atvidadeProjeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.atvidadeProjeto.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

} 
