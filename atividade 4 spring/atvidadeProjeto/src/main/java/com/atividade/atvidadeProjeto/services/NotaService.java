package com.atividade.atvidadeProjeto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atividade.atvidadeProjeto.dtos.NotaDTO;
import com.atividade.atvidadeProjeto.entities.Aluno;
import com.atividade.atvidadeProjeto.entities.Nota;
import com.atividade.atvidadeProjeto.exceptions.DBException;
import com.atividade.atvidadeProjeto.exceptions.ResourceNotFoundException;
import com.atividade.atvidadeProjeto.repositories.AlunoRepository;
import com.atividade.atvidadeProjeto.repositories.NotaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotaService {
    @Autowired
    private NotaRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public NotaDTO findById(Long id) {
        Nota nota = repository.findById(id).get();
        return new NotaDTO(nota);
    }
    @Transactional
    public NotaDTO insert(Long id,NotaDTO dto) {
        Aluno alunoEntity = alunoRepository.getReferenceById(id);
        Nota entity = new Nota();
        entity.setNomeDisciplina(dto.getNomeDisciplina());
        entity.setNota(dto.getNota());
        entity.setAluno(alunoEntity);
        entity = repository.save(entity);
        return new NotaDTO(entity);
    }
    @Transactional
    public NotaDTO update(Long id, NotaDTO dto) {
        try {
            Nota entity = repository.getReferenceById(id);
            entity.setNomeDisciplina(dto.getNomeDisciplina());
            entity.setNota(dto.getNota());
            entity.setAluno(entity.getAluno());
            entity = repository.save(entity);
            return new NotaDTO(entity);
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
    @Transactional(readOnly = true)
    public List<NotaDTO> getNotasbyAlunoId(Long id){
        List<Nota> entity = repository.findByAlunoId(id);
        List<NotaDTO> NotasDTO = new ArrayList<>();
        for(Nota nota: entity){
            NotasDTO.add(new NotaDTO(nota));
        }
        return NotasDTO;
    }
}
