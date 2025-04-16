package com.example.demo.Trabalho.Controller;

import com.example.demo.Trabalho.Dto.TrabalhoDto;
import com.example.demo.Trabalho.Service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

        @Autowired
        private TrabalhoService trabalhoService;

        @PostMapping
        public ResponseEntity<TrabalhoDto> createTrabalho(@RequestBody TrabalhoDto trabalhoDto) {
            TrabalhoDto savedtrabalho = trabalhoService.save(trabalhoDto);
            return ResponseEntity.ok(savedtrabalho);
        }

        @GetMapping
        public ResponseEntity<List<TrabalhoDto>> getAllTrabalhos() {
            List<TrabalhoDto> trabalhoDto = trabalhoService.getAllTrabalhos();
            return ResponseEntity.ok(trabalhoDto);
        }

        @GetMapping("/{id}")
        public ResponseEntity<TrabalhoDto> getTrabalhoById(@PathVariable Long id) {
            TrabalhoDto trabalhoDto = trabalhoService.getTrabalhoById(id);
            return ResponseEntity.ok(trabalhoDto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<TrabalhoDto> updateTrabalho(@PathVariable Long id, @RequestBody TrabalhoDto trabalhoDto) {
            TrabalhoDto updatedtrabalho = trabalhoService.update(id, trabalhoDto);
            return ResponseEntity.ok(updatedtrabalho);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTrabalho(@PathVariable Long id) {
            trabalhoService.delete(id);
            return ResponseEntity.noContent().build();
        }
}

