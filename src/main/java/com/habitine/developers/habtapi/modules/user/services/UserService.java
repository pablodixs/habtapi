package com.habitine.developers.habtapi.modules.user.services;

import com.habitine.developers.habtapi.modules.user.exceptions.UserAlreadyExistsException;
import com.habitine.developers.habtapi.modules.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.entities.UserEntity;
import com.habitine.developers.habtapi.modules.user.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   public UserEntity createNewUser(UserDTO userDTO) throws UserAlreadyExistsException {
      var userAlreadyExists = this.verifyIfUserAlreadyExists(userDTO);

      if(userAlreadyExists) {
         throw new UserAlreadyExistsException();
      }

      UserEntity user = UserEntity.builder()
              .displayName(userDTO.getDisplayName())
              .email(userDTO.getEmail())
              .username(userDTO.getUsername())
              .passwordHash(userDTO.getPassword())
              .build();

      return this.userRepository.save(user);
   }

   public Boolean verifyIfUserAlreadyExists(UserDTO userDTO) {
      var result = this.userRepository.findByEmailOrUsername(userDTO.getEmail(), userDTO.getUsername());

      return !result.isEmpty();
   }

   public List<UserEntity> findAllUsers() {
      return this.userRepository.findAll();
   }

   public UserEntity findUserById(UUID id) throws UserNotFoundException {
      Optional<UserEntity> user = this.userRepository.findById(id);

      if(user.isEmpty()) {
         throw new UserNotFoundException();
      }

      return user.get();
   }
}
