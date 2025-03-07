package com.example.CRUD.DTOs;

import java.util.Date;

import com.example.CRUD.Models.Campeonato;

public class CampeonatoDTO {
    public String nome;
    public Date dataInicio;
    public Date dataFim;

    public CampeonatoDTO() {
    }

    public CampeonatoDTO(Campeonato campeonato) {
        this.nome = campeonato.getNome();
        this.dataInicio = campeonato.getDataInicio();
        this.dataFim = campeonato.getDataFim();
    }
}
