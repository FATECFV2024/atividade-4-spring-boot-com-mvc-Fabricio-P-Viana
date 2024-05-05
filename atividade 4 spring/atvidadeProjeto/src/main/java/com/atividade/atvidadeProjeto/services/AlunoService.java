package com.atividade.atvidadeProjeto.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.atividade.atvidadeProjeto.dtos.AlunoDTO;

import com.atividade.atvidadeProjeto.entities.Aluno;
import com.atividade.atvidadeProjeto.exceptions.DBException;
import com.atividade.atvidadeProjeto.exceptions.ResourceNotFoundException;
import com.atividade.atvidadeProjeto.repositories.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno aluno = repository.findById(id).get();
        return new AlunoDTO(aluno);
    }
    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();
        entity.setNome(dto.getNome());
        entity.setCurso(dto.getCurso());
        entity.setIdade(dto.getIdade());
        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }
    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        try {
            Aluno entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setCurso(dto.getCurso());
            entity.setIdade(dto.getIdade());
            entity = repository.save(entity);
            return new AlunoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DBException("Violação de integridade referencial");
        }
    }
}
