package com.example.demo.Trabalho.Model;

import com.example.demo.Pessoa.Model.Pessoa;
import jakarta.persistence.*;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String end;

    public Trabalho() {}

    public Trabalho(String nome, String end) {
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

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Pessoa_id")
    private Pessoa pessoa;

}




