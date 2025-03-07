package com.example.CRUD.Controllers;

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

import com.example.CRUD.DTOs.ClassificacaoDTO;
import com.example.CRUD.Models.Classificacao;
import com.example.CRUD.Services.ClassificacaoService;

@RequestMapping("/classificacao")
@RestController
public class ClassificacaoController {
    @Autowired
    private ClassificacaoService classificacaoService;


    @GetMapping()
    public List<Classificacao> getAll() {
        return classificacaoService.getAll();
    }


    @PostMapping()
    public Classificacao post(@RequestBody()ClassificacaoDTO dto) {
        return classificacaoService.create(dto);
    }

    @PutMapping("{id}")
    public Classificacao put(@RequestBody()ClassificacaoDTO dto, @PathVariable Long id) {
        return classificacaoService.update(dto, id);
    }

    @DeleteMapping()
    public void put(long id) {
        classificacaoService.delete(id);
    }

}