package com.example.CRUD.Controllers;

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

import com.example.CRUD.DTOs.CampeonatoDTO;
import com.example.CRUD.Models.Campeonato;
import com.example.CRUD.Services.CampeonatoService;

@RequestMapping("/campeonato")
@RestController
public class CampeonatoController {
    @Autowired
    private CampeonatoService campeonatoService;


    @GetMapping()
    public ResponseEntity<List<Campeonato>> getAll() {
        return ResponseEntity.ok(campeonatoService.getAll());
    }


    @PostMapping()
    public ResponseEntity post(@RequestBody()CampeonatoDTO dto) {
        return ResponseEntity.status(201).body(campeonatoService.create(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Campeonato> put(@RequestBody()CampeonatoDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(campeonatoService.update(dto, id));
    }

    @DeleteMapping()
    public ResponseEntity put(long id) {
        campeonatoService.delete(id);
        return ResponseEntity.status(204).build();
    }

}