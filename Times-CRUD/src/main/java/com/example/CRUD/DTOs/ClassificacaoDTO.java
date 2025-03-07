package com.example.CRUD.DTOs;

import com.example.CRUD.Models.Classificacao;

public class ClassificacaoDTO {
    public Long timeId;
    public Long campeonatoId;
    public int pontos;


    public ClassificacaoDTO() {
    }

    public ClassificacaoDTO(Classificacao classificacao){
        this.timeId = classificacao.getTime().getId();
        this.campeonatoId = classificacao.getCampeonato().getId();
        this.pontos = classificacao.getPontos();
    }
}
