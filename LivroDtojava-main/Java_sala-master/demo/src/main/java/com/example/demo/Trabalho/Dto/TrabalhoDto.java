package com.example.demo.Trabalho.Dto;

import com.example.demo.Trabalho.Model.Trabalho;

public class TrabalhoDto {
    private Long id;
    private String nome;
    private String end;

    public TrabalhoDto() {
    }

    public TrabalhoDto(Long id, String nome, String end) {
        this.id = id;
        this.nome = nome;
        this.end = end;
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

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Trabalho transformarParaModelo() {
        return new Trabalho(this.nome, this.end);
    }
}

