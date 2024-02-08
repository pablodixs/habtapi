package com.habitine.developers.habtapi.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.entities.UserEntity;
import com.habitine.developers.habtapi.modules.user.repositories.UserRepository;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   public void createNewUser(UserDTO userDTO) {
      UserEntity user = new UserEntity();

      UserEntity.builder()
            .displayName(userDTO.getDisplayName())
            .email(userDTO.getEmail())
            .username(userDTO.getUsername())
            .passwordHash(userDTO.getPassword())
            .build();

      userRepository.save(user);
   }
}
