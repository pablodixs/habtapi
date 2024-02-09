package com.habitine.developers.habtapi.modules.habits.controllers;

import com.habitine.developers.habtapi.modules.habits.DTOs.HabitDTO;
import com.habitine.developers.habtapi.modules.habits.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping
    public ResponseEntity<Object> listHabitsFromUserId(@RequestParam("id") UUID id) {
        var habits = habitService.listHabitsByUserId(id);

        return ResponseEntity.ok().body(habits);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createHabit(@RequestBody HabitDTO habitDTO) {
        var newHabit = this.habitService.createNewHabit(habitDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newHabit);
    }
}
