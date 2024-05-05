package com.atividade.atvidadeProjeto.dtos;

import java.util.List;

public class AlunoDetalhadoDTO {
    private AlunoDTO aluno;
    private List<NotaDTO> notas;
    private List<EnderecoDTO> enderecos;

    public AlunoDetalhadoDTO() {
    }
    public AlunoDetalhadoDTO(AlunoDTO aluno, List<EnderecoDTO> dtoEnderecos, List<NotaDTO> notas) {
        this.aluno = aluno;
        this.enderecos = dtoEnderecos;
        this.notas = notas;
    }
    public AlunoDTO getAluno() {
        return aluno;
    }
    public List<NotaDTO> getNotas() {
        return notas;
    }
    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }
}
