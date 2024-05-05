package com.atividade.atvidadeProjeto.dtos;

import com.atividade.atvidadeProjeto.entities.Nota;

public class NotaDTO {
    private Long id;
    private String nomeDisciplina;
    private double nota;
    
    public NotaDTO(Nota entity){
        id = entity.getId();
        nomeDisciplina = entity.getNomeDisciplina();
        nota = entity.getNota();
    }
    public NotaDTO(Long id, String nomeDisciplina, double nota) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
        this.nota = nota;
    }
    public NotaDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    
}
