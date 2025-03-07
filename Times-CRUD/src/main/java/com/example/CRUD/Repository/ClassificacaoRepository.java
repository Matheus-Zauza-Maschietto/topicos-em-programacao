package com.example.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.Models.Classificacao;

@Repository
public interface ClassificacaoRepository
    extends JpaRepository<Classificacao, Long> {
}
