package com.example.CRUD.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.DTOs.TimeDTO;
import com.example.CRUD.Models.Time;
import com.example.CRUD.Repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Optional<Time> getById(long id) {
        return repository.findById(id);
    }

    public List<Time> getAll() {
        return repository.findAll();
    }

    public Time create(TimeDTO dto) {
        Time time = new Time(dto);
        return repository.save(time);
    }

    public Time update(TimeDTO dto, long id) {
        Time time = repository.findById(id).get();
        time.updateFromDTO(dto);
        return repository.save(time);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
