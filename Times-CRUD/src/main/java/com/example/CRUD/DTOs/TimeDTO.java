package com.example.CRUD.DTOs;

import com.example.CRUD.Models.Time;

public class TimeDTO {
    public String nome;

    public TimeDTO() {
    }

    public TimeDTO(Time time) {
        this.nome = time.getNome();
    }
}
