package com.habitine.developers.habtapi.modules.habits.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserHabitsEntity {
    private UUID userId;
    private List<HabitEntity> habits;
}
