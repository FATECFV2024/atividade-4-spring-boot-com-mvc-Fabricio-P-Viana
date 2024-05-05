package com.atividade.atvidadeProjeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.atvidadeProjeto.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long> {

    List<Nota> findByAlunoId(Long id);

    // void deleteByAlunoId(Long id);

    // boolean existsByAlunoId(Long id);

} 
