package com.habitine.developers.habtapi.modules.habits.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.habitine.developers.habtapi.modules.user.entities.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "habits")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   private String title;

   private String description;

   @CreationTimestamp
   private LocalDateTime createdAt;

   private String daysOfWeek;

   private Integer duration;

   private String category;

   private List<String> tags;

   @OneToMany(mappedBy = "habit")
   private List<HabitProgressEntity> historic;

   @ManyToOne
   @JoinColumn(name = "user_id")
   @JsonManagedReference
   private UserEntity user;

}
