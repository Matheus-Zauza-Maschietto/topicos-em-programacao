package com.example.CRUD.Models;

import java.util.List;

import com.example.CRUD.DTOs.TimeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @OneToMany
    private List<Classificacao> classificacao;


    public Time(){ }

    public Time(TimeDTO timeDTO) {
        this.nome = timeDTO.nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Classificacao> getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(List<Classificacao> classificacao) {
        this.classificacao = classificacao;
    }

    public void updateFromDTO(TimeDTO timeDTO) {
        this.nome = timeDTO.nome;
    }

}