package com.example.CRUD.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.DTOs.CampeonatoDTO;
import com.example.CRUD.Models.Campeonato;
import com.example.CRUD.Repository.CampeonatoRepository;

@Service
public class CampeonatoService {  
    
    @Autowired
    private CampeonatoRepository repository;

    public Optional<Campeonato> getById(long id){
        return repository.findById(id);
    }

    public List<Campeonato> getAll(){
        return repository.findAll();
    }

    public Campeonato create(CampeonatoDTO dto){
        Campeonato campeonato = new Campeonato(dto);
        return repository.save(campeonato);
    }

    public Campeonato update(CampeonatoDTO dto, long id){
        Campeonato campeonato = repository.findById(id).get();
        campeonato.updateFromDTO(dto);        
        return repository.save(campeonato);
    }


    public void delete(long id){
        repository.deleteById(id);
    }
}
