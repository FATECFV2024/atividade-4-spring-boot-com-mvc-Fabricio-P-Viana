package com.atividade.atvidadeProjeto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atividade.atvidadeProjeto.dtos.NotaDTO;
import com.atividade.atvidadeProjeto.services.NotaService;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value="/notas")
public class NotaController {
    @Autowired
    private NotaService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<NotaDTO> findById(@PathVariable Long id) {
        NotaDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping(value = "/{id}")
    public ResponseEntity<NotaDTO> insert(@PathVariable Long id,@RequestBody NotaDTO dto) {
        dto = service.insert(id,dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<NotaDTO> update(@PathVariable Long id, @RequestBody NotaDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value="/aluno/{id}")
    public ResponseEntity<List<NotaDTO>> findNotaByIdAluno(@PathVariable Long id){
        List<NotaDTO> dto = service.getNotasbyAlunoId(id);
        return ResponseEntity.ok().body(dto);
    }
}
