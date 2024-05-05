package com.atividade.atvidadeProjeto.dtos;

import com.atividade.atvidadeProjeto.entities.Aluno;

public class AlunoDTO {
    private Long id;
    private String nome,curso;
    private int idade;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno entity) {
        id = entity.getId();
        nome = entity.getNome();
        curso = entity.getCurso();
        idade = entity.getIdade();
    }
    
    public AlunoDTO(Long id, String nome, String curso, int idade) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
