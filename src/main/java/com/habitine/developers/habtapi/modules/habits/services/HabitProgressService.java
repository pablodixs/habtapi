package com.habitine.developers.habtapi.modules.habits.services;

import com.habitine.developers.habtapi.modules.habits.entities.HabitProgressEntity;
import com.habitine.developers.habtapi.modules.habits.DTOs.HabitProgressDTO;
import com.habitine.developers.habtapi.modules.habits.repositories.HabitProgressRepository;
import com.habitine.developers.habtapi.modules.habits.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitProgressService {
    @Autowired
    HabitProgressRepository habitProgressRepository;

    @Autowired
    HabitRepository habitRepository;

    public List<HabitProgressEntity> listAllHabitProgressById(UUID id) {
        var habitProgresses = this.habitProgressRepository.findAllByHabitId(id);

        return habitProgresses;
    }

    public HabitProgressEntity createNewProgress(HabitProgressDTO dto) throws Exception {

        var habit = this.habitRepository.findById(dto.getHabitId());

        if (habit.isEmpty()) {
            throw new Exception("Habit does not exists.");
        }

        HabitProgressEntity newProgress = HabitProgressEntity.builder()
                .habitId(dto.getHabitId())
                .duration(dto.getDuration())
                .endedAt(dto.getEndedAt())
                .startedAt(dto.getStartedAt())
                .relatedDay(dto.getRelatedDay())
                .wasDone(dto.getWasDone())
                .wasInterrupted(dto.getWasInterrupted())
                .habit(habit.get())
                .build();

        return this.habitProgressRepository.save(newProgress);
    }
}
