package com.Livros.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livros.demo.domain.Livro;
import com.Livros.demo.dtos.LivroDTO;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private com.Livros.demo.service.LivroService LivroService;

    @GetMapping(value = "")
    public ResponseEntity<List<LivroDTO>> getLivros() throws Exception {
        return ResponseEntity.ok(LivroService.getLivros().stream().map(p -> new LivroDTO(p)).toList());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<LivroDTO> getLivroById(@PathVariable int id) {
        return ResponseEntity.ok(new LivroDTO(LivroService.getLivroById(id)));
    }

    @PostMapping(value = "")
    public ResponseEntity<LivroDTO> createLivro(@RequestBody Livro livro) {
        return ResponseEntity.status(201).body(new LivroDTO(LivroService.createLivro(livro)));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<LivroDTO> updateLivro(@PathVariable int id, @RequestBody Livro livro) {
        return ResponseEntity.ok(new LivroDTO(LivroService.updateLivro(id, livro)));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteLivro(@PathVariable int id) {
        LivroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }

}
