package com.Livros.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livros.demo.domain.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private com.Livros.demo.service.LivroService LivroService;

    @GetMapping(value = "")
    public List<Livro> getLivros() throws Exception {
        return LivroService.getLivros();
    }

    @GetMapping(value = "{id}")
    public Livro getLivroById(@PathVariable int id) {
        return LivroService.getLivroById(id);
    }

    @PostMapping(value = "")
    public Livro createLivro(@RequestBody Livro livro) {
        return LivroService.createLivro(livro);
    }

    @PutMapping(value = "{id}")
    public Livro updateLivro(@PathVariable int id, @RequestBody Livro livro) {
        return LivroService.updateLivro(id, livro);
    }

    @DeleteMapping(value = "{id}")
    public void deleteLivro(@PathVariable int id) {
        LivroService.deleteLivro(id);
    }

}
