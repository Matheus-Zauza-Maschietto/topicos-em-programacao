package com.Livros.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Livros.demo.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
