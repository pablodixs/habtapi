package com.habitine.developers.habtapi.modules.habits.controllers;

import com.habitine.developers.habtapi.modules.habits.DTOs.HabitDTO;
import com.habitine.developers.habtapi.modules.habits.services.HabitService;
import com.habitine.developers.habtapi.modules.user.exceptions.InvalidUserIdException;
import com.habitine.developers.habtapi.modules.user.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Object> listHabitsFromUserId(@RequestParam("id") UUID id) {
        userService.findUserById(id);

        var habits = habitService.listHabitsByUserId(id);

        return ResponseEntity.ok().body(habits);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createHabit(@RequestBody @NotNull HabitDTO habitDTO) {
        habitService.verifyIfUserIdIsMissing(habitDTO.getUserId());

        userService.findUserById(habitDTO.getUserId());

        var newHabit = this.habitService.createNewHabit(habitDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newHabit);
    }
}
