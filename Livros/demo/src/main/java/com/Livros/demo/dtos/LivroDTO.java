package com.Livros.demo.dtos;

import com.Livros.demo.domain.Livro;

public class LivroDTO {
    private String nome;
    private String autor;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.nome = livro.getNome();
        this.autor = livro.getAutor();
    }
}
