package com.example.demo.Pessoa.Dto;

import com.example.demo.Pessoa.Model.Pessoa;

public class PessoaDto {
    private Long id;
    private Long cpf;
    private Long idade;

    public PessoaDto() {
    }

    public PessoaDto(Long id, Long cpf, Long idade) {
        this.id = id;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Pessoa transformarParaModelo() {
        return new Pessoa(this.cpf, this.idade);
    }
}

