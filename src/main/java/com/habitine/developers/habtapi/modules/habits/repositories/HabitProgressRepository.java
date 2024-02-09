package com.habitine.developers.habtapi.modules.habits.repositories;

import com.habitine.developers.habtapi.modules.habits.entities.HabitProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HabitProgressRepository extends JpaRepository<HabitProgressEntity, UUID> {
    List<HabitProgressEntity> findAllByHabitId(UUID id);
}
