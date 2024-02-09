package com.habitine.developers.habtapi.modules.habits.repositories;

import com.habitine.developers.habtapi.modules.habits.entities.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HabitRepository extends JpaRepository<HabitEntity, UUID> {
    public List<HabitEntity> findAllByUserId(UUID id);
}
