package com.habitine.developers.habtapi.modules.habits.DTOs;

import com.habitine.developers.habtapi.modules.user.entities.UserEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitDTO {
    private String title;
    private String description;
    private String daysOfWeek;
    private Integer duration;
    private String category;
    private List<String> tags;
    private UserEntity user;
}
