package com.example.demo.Pessoa.Controller;

import com.example.demo.Pessoa.Dto.PessoaDto;
import com.example.demo.Pessoa.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

        @Autowired
        private PessoaService pessoaService;

        @PostMapping
        public ResponseEntity<PessoaDto> createPessoa(@RequestBody PessoaDto pessoaDto) {
            PessoaDto savedPessoa = pessoaService.save(pessoaDto);
            return ResponseEntity.ok(savedPessoa);
        }

        @GetMapping
        public ResponseEntity<List<PessoaDto>> getAllPessoas() {
            List<PessoaDto> pessoaDto = pessoaService.getAllPessoas();
            return ResponseEntity.ok(pessoaDto);
        }

        @GetMapping("/{id}")
        public ResponseEntity<PessoaDto> getPessoaById(@PathVariable Long id) {
            PessoaDto pessoaDto = pessoaService.getPessoaById(id);
            return ResponseEntity.ok(pessoaDto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<PessoaDto> updatePessoa(@PathVariable Long id, @RequestBody PessoaDto pessoaDto) {
            PessoaDto updatedPessoa = pessoaService.update(id, pessoaDto);
            return ResponseEntity.ok(updatedPessoa);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
            pessoaService.delete(id);
            return ResponseEntity.noContent().build();
        }
}

