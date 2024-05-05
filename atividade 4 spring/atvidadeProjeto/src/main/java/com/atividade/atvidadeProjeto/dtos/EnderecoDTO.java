package com.atividade.atvidadeProjeto.dtos;

import com.atividade.atvidadeProjeto.entities.Endereco;

public class EnderecoDTO {
    private Long id;
    private int numero;
    private String rua,cidade,estado,cep;

    public EnderecoDTO(Endereco entity) {
        id = entity.getId();
        numero = entity.getNumero();
        rua = entity.getRua();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        cep = entity.getCep();
    }
    public EnderecoDTO(Long id, int numero, String rua, String cidade, String estado, String cep) {
        this.id = id;
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public EnderecoDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
