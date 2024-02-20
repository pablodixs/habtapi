package com.habitine.developers.habtapi.modules.habits.controllers;

import com.habitine.developers.habtapi.modules.habits.DTOs.HabitProgressDTO;
import com.habitine.developers.habtapi.modules.habits.entities.HabitProgressEntity;
import com.habitine.developers.habtapi.modules.habits.services.HabitProgressService;
import com.habitine.developers.habtapi.modules.user.exceptions.InvalidUserIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/habit/progress")
public class HabitProgressController {
    @Autowired
    HabitProgressService habitProgressService;

    @GetMapping
    public ResponseEntity<List<HabitProgressEntity>> showProgressById(@RequestParam("id") UUID id) {
        var progresses = habitProgressService.listAllHabitProgressById(id);

        return ResponseEntity.ok().body(progresses);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createNewProgress(@RequestBody HabitProgressDTO dto) {
        try {
            var progress = this.habitProgressService.createNewProgress(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body(progress);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
