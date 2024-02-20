package com.habitine.developers.habtapi.modules.habits.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
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

   @Column(name = "habitId", insertable = false, updatable = false)
   private UUID habitId;

   @ManyToOne
   @JoinColumn(name = "habitId")
   private HabitEntity habit;
}
