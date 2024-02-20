package com.habitine.developers.habtapi.modules.habits.services;

import com.habitine.developers.habtapi.modules.habits.DTOs.HabitDTO;
import com.habitine.developers.habtapi.modules.habits.entities.HabitEntity;
import com.habitine.developers.habtapi.modules.habits.exceptions.MissingUserException;
import com.habitine.developers.habtapi.modules.habits.repositories.HabitRepository;
import com.habitine.developers.habtapi.modules.user.exceptions.UserNotFoundException;
import com.habitine.developers.habtapi.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitService {
    @Autowired
    HabitRepository habitRepository;

    @Autowired
    UserRepository userRepository;

    public List<HabitEntity> listHabitsByUserId(UUID id) {
        return this.habitRepository.findAllByUserId(id);
    }

    public HabitEntity createNewHabit(HabitDTO habitDTO) {

        var user = userRepository.findById(habitDTO.getUserId());

        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }

        HabitEntity habit = HabitEntity.builder()
                .title(habitDTO.getTitle())
                .description(habitDTO.getDescription())
                .category(habitDTO.getCategory())
                .duration(habitDTO.getDuration())
                .tags(habitDTO.getTags())
                .daysOfWeek(habitDTO.getDaysOfWeek())
                .userId(habitDTO.getUserId())
                .user(user.get())
                .build();

        return habitRepository.save(habit);
    }

    public void verifyIfUserIdIsMissing(UUID id) {
        if(id == null) {
            throw new MissingUserException();
        }
    }
}
