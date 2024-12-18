package com.habitine.developers.habtapi.modules.user.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.habitine.developers.habtapi.modules.habits.entities.HabitEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tbUser")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @Column(unique = true)
   @NotNull
   private String username;

   @Column(unique = true)
   @NotNull
   private String email;

   @NotNull
   private String displayName;

   @JsonIgnore
   private String passwordHash;

   private String bio;

   private String avatarUrl;

   @CreationTimestamp
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;

   @OneToMany(mappedBy = "user")
   @JsonBackReference
   private List<HabitEntity> habits;
}
