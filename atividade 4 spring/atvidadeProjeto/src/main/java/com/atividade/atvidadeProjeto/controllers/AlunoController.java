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
import com.atividade.atvidadeProjeto.dtos.AlunoDTO;
import com.atividade.atvidadeProjeto.dtos.AlunoDetalhadoDTO;
import com.atividade.atvidadeProjeto.dtos.EnderecoDTO;
import com.atividade.atvidadeProjeto.dtos.NotaDTO;
import com.atividade.atvidadeProjeto.services.AlunoService;
import com.atividade.atvidadeProjeto.services.EnderecoService;
import com.atividade.atvidadeProjeto.services.NotaService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value="/alunos")
public class AlunoController {
    @Autowired
    private AlunoService service;
    @Autowired
    private NotaService notaService;
    @Autowired
    private EnderecoService enderecoService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        AlunoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping(value = "/InfoCompleta/{id}")
    public ResponseEntity<AlunoDetalhadoDTO> findByIdAllInformation(@PathVariable Long id) {
        AlunoDTO dtoAluno = service.findById(id);
        List<NotaDTO> dtoNota = notaService.getNotasbyAlunoId(id);
        List<EnderecoDTO> dtoEndereco = enderecoService.getEnderecosbyAlunoId(id);
        AlunoDetalhadoDTO alunoDetalhadoDTO = new AlunoDetalhadoDTO(dtoAluno,dtoEndereco,dtoNota);
        return ResponseEntity.ok().body(alunoDetalhadoDTO);
    }
    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
