package com.example.CRUD.Models;

import java.util.Date;
import java.util.List;

import com.example.CRUD.DTOs.CampeonatoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @OneToMany
    private List<Classificacao> classificacao;
    private Date dataInicio;
    private Date dataFim;

    public Campeonato(){ }

    public Campeonato(CampeonatoDTO campeonatoDTO) {
        this.nome = campeonatoDTO.nome;
        this.dataInicio = campeonatoDTO.dataInicio;
        this.dataFim = campeonatoDTO.dataFim;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public List<Classificacao> getClassificacao() {
        return classificacao;
    }

    public long getId() {
        return id;
    }

    public void setClassificacao(List<Classificacao> classificacao) {
        this.classificacao = classificacao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void updateFromDTO(CampeonatoDTO campeonatoDTO) {
        this.nome = campeonatoDTO.nome;
        this.dataInicio = campeonatoDTO.dataInicio;
        this.dataFim = campeonatoDTO.dataFim;
    }
}
