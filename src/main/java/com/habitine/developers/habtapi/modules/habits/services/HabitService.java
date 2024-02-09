package com.habitine.developers.habtapi.modules.habits.services;

import com.habitine.developers.habtapi.modules.habits.DTOs.HabitDTO;
import com.habitine.developers.habtapi.modules.habits.entities.HabitEntity;
import com.habitine.developers.habtapi.modules.habits.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitService {
    @Autowired
    HabitRepository habitRepository;

    public List<HabitEntity> listHabitsByUserId(UUID id) {
        return this.habitRepository.findAllByUserId(id);
    }

    public HabitEntity createNewHabit(HabitDTO habitDTO) {
        HabitEntity habit = HabitEntity.builder()
                .title(habitDTO.getTitle())
                .description(habitDTO.getDescription())
                .category(habitDTO.getCategory())
                .duration(habitDTO.getDuration())
                .tags(habitDTO.getTags())
                .daysOfWeek(habitDTO.getDaysOfWeek())
                .userId(habitDTO.getUserId())
                .user(habitDTO.getUser())
                .build();

        return this.habitRepository.save(habit);
    }
}
