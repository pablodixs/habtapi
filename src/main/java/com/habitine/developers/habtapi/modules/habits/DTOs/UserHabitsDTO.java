package com.habitine.developers.habtapi.modules.habits.DTOs;

import com.habitine.developers.habtapi.modules.habits.entities.HabitEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHabitsDTO {
    private UUID userId;
    private List<HabitEntity> habits;
}
