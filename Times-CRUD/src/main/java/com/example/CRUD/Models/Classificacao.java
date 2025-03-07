package com.example.CRUD.Models;

import com.example.CRUD.DTOs.ClassificacaoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Time time;
    @ManyToOne
    private Campeonato campeonato;
    private int pontos;

    public Classificacao() { }

    public Classificacao(ClassificacaoDTO dto, Time time, Campeonato campeonato) {
        this.time = time;
        this.campeonato = campeonato;
        this.pontos = dto.pontos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void updateFromDTO(ClassificacaoDTO dto) {
        this.pontos = dto.pontos;
    }
    
}
