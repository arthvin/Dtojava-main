package com.example.demo.Pessoa.Repository;

import com.example.demo.Pessoa.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaInterface extends JpaRepository<Pessoa, Long>{
}
