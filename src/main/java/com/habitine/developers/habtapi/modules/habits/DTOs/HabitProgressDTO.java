package com.habitine.developers.habtapi.modules.habits.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitProgressDTO {
    private UUID habitId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime relatedDay;
    private Integer duration;
    private Boolean wasDone;
    private Boolean wasInterrupted;
}
