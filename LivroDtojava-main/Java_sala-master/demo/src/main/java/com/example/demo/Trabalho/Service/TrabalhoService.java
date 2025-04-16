package com.example.demo.Trabalho.Service;

import com.example.demo.Trabalho.Dto.TrabalhoDto;
import com.example.demo.Trabalho.Model.Trabalho;
import com.example.demo.Trabalho.Repository.TrabalhoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoInterface trabalhoInterface;

    // Create (POST)
    public TrabalhoDto save(TrabalhoDto trabalhoDto) {
        Trabalho trabalho = trabalhoDto.transformarParaModelo();
        Trabalho savedtrabalho = trabalhoInterface.save(trabalho);
        return new TrabalhoDto(savedtrabalho.getId(), savedtrabalho.getNome(), savedtrabalho.getEnd());
    }

    // Read (GET)
    public List<TrabalhoDto> getAllTrabalhos() {
        List<Trabalho> trabalho = trabalhoInterface.findAll();
        return trabalho.stream()
                .map(t -> new TrabalhoDto(t.getId(), t.getNome(), t.getEnd()))
                .collect(Collectors.toList());
    }

    public TrabalhoDto getTrabalhoById(Long id) {
        Trabalho trabalho = trabalhoInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "trabalho não encontrada"));
        return new TrabalhoDto(trabalho.getId(), trabalho.getNome(), trabalho.getEnd());
    }

    // Update (PUT)
    public TrabalhoDto update(Long id, TrabalhoDto trabalhoDto) {
        Trabalho trabalhoExistente = trabalhoInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho não encontrada"));

        trabalhoExistente.setNome(trabalhoDto.getNome());
        trabalhoExistente.setEnd(trabalhoDto.getEnd());

        Trabalho updatedtrabalho = trabalhoInterface.save(trabalhoExistente);
        return new TrabalhoDto(updatedtrabalho.getId(), updatedtrabalho.getNome(), updatedtrabalho.getEnd());
    }

    // Delete (DELETE)
    public void delete(Long id) {
        Trabalho trabalho = trabalhoInterface.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho não encontrado"));

        trabalhoInterface.delete(trabalho);
    }
}
