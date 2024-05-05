package com.atividade.atvidadeProjeto.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome,curso;
    private int idade;

    @OneToMany(mappedBy = "aluno")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Nota> notas = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(Long id, String nome, String curso, int idade, List<Nota> notas, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.notas = notas;
        this.enderecos = enderecos;
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
    
    public List<Nota> getNotas() {
        return notas;
    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}
