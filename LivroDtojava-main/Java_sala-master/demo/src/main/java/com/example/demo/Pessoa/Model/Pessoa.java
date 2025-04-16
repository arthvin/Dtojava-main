package com.example.demo.Pessoa.Model;

import com.example.demo.Trabalho.Model.Trabalho;
import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cpf;

    private Long idade;

    public Pessoa() {}

    public Pessoa(Long cpf, Long idade) {
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

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Trabalho_id")
    private Trabalho trabalho;
}




