package com.example.CRUD.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.DTOs.ClassificacaoDTO;
import com.example.CRUD.Models.Campeonato;
import com.example.CRUD.Models.Classificacao;
import com.example.CRUD.Models.Time;
import com.example.CRUD.Repository.CampeonatoRepository;
import com.example.CRUD.Repository.ClassificacaoRepository;
import com.example.CRUD.Repository.TimeRepository;

@Service
public class ClassificacaoService {  
    
    @Autowired
    private ClassificacaoRepository repository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public Optional<Classificacao> getById(long id){
        return repository.findById(id);
    }

    public List<Classificacao> getAll(){
        return repository.findAll();
    }

    public Classificacao upsert(Classificacao classificacao){
        return repository.save(classificacao);
    }

    public Classificacao create(ClassificacaoDTO dto){
        Time time = timeRepository.findById(dto.timeId).get();
        Campeonato campeonato = campeonatoRepository.findById(dto.campeonatoId).get();
        Classificacao classificacao = new Classificacao(dto, time, campeonato);
        return repository.save(classificacao);
    }

    public Classificacao update(ClassificacaoDTO dto, long id){
        Classificacao classificacao = repository.findById(id).get();
        classificacao.updateFromDTO(dto);
        return repository.save(classificacao);
    }

    public void delete(long id){
        repository.deleteById(id);
    }
}
