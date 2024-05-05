package com.atividade.atvidadeProjeto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atividade.atvidadeProjeto.dtos.EnderecoDTO;
import com.atividade.atvidadeProjeto.entities.Aluno;
import com.atividade.atvidadeProjeto.entities.Endereco;
import com.atividade.atvidadeProjeto.exceptions.DBException;
import com.atividade.atvidadeProjeto.exceptions.ResourceNotFoundException;
import com.atividade.atvidadeProjeto.repositories.AlunoRepository;
import com.atividade.atvidadeProjeto.repositories.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;


    @Transactional(readOnly = true)
    public EnderecoDTO findById(Long id) {
        Endereco endereco = repository.findById(id).get();
        return new EnderecoDTO(endereco);
    }
    @Transactional
    public EnderecoDTO insert(Long id,EnderecoDTO dto) {
        Endereco entity = new Endereco();
        Aluno alunoEntity = alunoRepository.getReferenceById(id);
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setNumero(dto.getNumero());
        entity.setRua(dto.getRua());
        entity.setAluno(alunoEntity);
        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }
    @Transactional
    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        try {
            Endereco entity = repository.getReferenceById(id);
            entity.setCep(dto.getCep());
            entity.setCidade(dto.getCidade());
            entity.setEstado(dto.getEstado());
            entity.setNumero(dto.getNumero());
            entity.setRua(dto.getRua());
            entity = repository.save(entity);
            return new EnderecoDTO(entity);
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
    public List<EnderecoDTO> getEnderecosbyAlunoId(Long id){
        List<Endereco> entity = repository.findByAlunoId(id);
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        for(Endereco endereco: entity){
            enderecosDTO.add(new EnderecoDTO(endereco));
        }
        return enderecosDTO;
    }
}
