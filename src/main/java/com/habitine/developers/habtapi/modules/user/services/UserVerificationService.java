package com.habitine.developers.habtapi.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitine.developers.habtapi.modules.user.exceptions.UserAlreadyExistsException;
import com.habitine.developers.habtapi.modules.user.repositories.UserRepository;

@Service
public class UserVerificationService {
   @Autowired
   private UserRepository userRepository;

   public Boolean verifyIfEmailIsInUse(String email) throws UserAlreadyExistsException {
      var user = this.userRepository.findByEmail(email);

      if (user != null) {
         throw new UserAlreadyExistsException("Email is already in use.");
      }

      return false;
   }

   public Boolean verifyIfUsernameIsInUse(String username) throws UserAlreadyExistsException {
      var user = this.userRepository.findByUsername(username);

      if (user != null) {
         throw new UserAlreadyExistsException("Username is already in use.");
      }

      return false;
   }
}
