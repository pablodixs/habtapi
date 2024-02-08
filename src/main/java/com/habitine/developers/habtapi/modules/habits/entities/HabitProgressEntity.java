package com.habitine.developers.habtapi.modules.habits.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "habitProgress")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitProgressEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   private LocalDateTime startedAt;

   private LocalDateTime endedAt;

   private LocalDateTime relatedDay;

   private Integer duration;

   private Boolean wasDone;

   private Boolean wasInterrupted;

   @ManyToOne
   @JoinColumn(name = "habit_id")
   private HabitEntity habit;
}
