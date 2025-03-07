package com.example.CRUD.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.DTOs.TimeDTO;
import com.example.CRUD.Models.Time;
import com.example.CRUD.Services.TimeService;

@RequestMapping("/time")
@RestController
public class TimeController {
    @Autowired
    private TimeService timeService;


    @GetMapping()
    public List<Time> getAll() {
        return timeService.getAll();
    }


    @PostMapping()
    public Time post(@RequestBody()TimeDTO time) {
        return timeService.create(time);
    }

    @PutMapping("{id}")
    public Time put(@RequestBody()TimeDTO dto, @PathVariable Long id) {
        return timeService.update(dto, id);
    }

    @DeleteMapping()
    public void put(long id) {
        timeService.delete(id);
    }

}