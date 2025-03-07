package com.example.CRUD.Repository;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CRUD.Models.Campeonato;

@Repository
public interface CampeonatoRepository
    extends JpaRepository<Campeonato, Long> {
}
