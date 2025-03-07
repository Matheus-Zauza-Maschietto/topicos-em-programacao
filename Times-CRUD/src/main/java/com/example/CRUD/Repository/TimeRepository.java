package com.example.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CRUD.Models.Time;

@Repository
public interface TimeRepository
    extends JpaRepository<Time, Long> {
}
