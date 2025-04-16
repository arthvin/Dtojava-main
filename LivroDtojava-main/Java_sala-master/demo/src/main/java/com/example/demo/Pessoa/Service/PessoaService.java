package com.example.demo.Pessoa.Service;

import com.example.demo.Pessoa.Dto.PessoaDto;
import com.example.demo.Pessoa.Model.Pessoa;
import com.example.demo.Pessoa.Repository.PessoaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaInterface pessoaInterface;

    // Create (POST)
    public PessoaDto save(PessoaDto pessoaDto) {
        Pessoa pessoa = pessoaDto.transformarParaModelo();
        Pessoa savedPessoa = pessoaInterface.save(pessoa);
        return new PessoaDto(savedPessoa.getId(), savedPessoa.getCpf(), savedPessoa.getIdade());
    }

    // Read (GET)
    public List<PessoaDto> getAllPessoas() {
        List<Pessoa> pessoa = pessoaInterface.findAll();
        return pessoa.stream()
                .map(p -> new PessoaDto(p.getId(), p.getCpf(), p.getIdade()))
                .collect(Collectors.toList());
    }

    public PessoaDto getPessoaById(Long id) {
        Pessoa pessoa = pessoaInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        return new PessoaDto(pessoa.getId(), pessoa.getCpf(), pessoa.getIdade());
    }

    // Update (PUT)
    public PessoaDto update(Long id, PessoaDto pessoaDto) {
        Pessoa PessoaExistente = pessoaInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));

        PessoaExistente.setCpf(pessoaDto.getCpf());
        PessoaExistente.setIdade(pessoaDto.getIdade());

        Pessoa updatedPessoa = pessoaInterface.save(PessoaExistente);
        return new PessoaDto(updatedPessoa.getId(), updatedPessoa.getCpf(), updatedPessoa.getIdade());
    }

    // Delete (DELETE)
    public void delete(Long id) {
        Pessoa pessoa = pessoaInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));

        pessoaInterface.delete(pessoa);
    }
}
