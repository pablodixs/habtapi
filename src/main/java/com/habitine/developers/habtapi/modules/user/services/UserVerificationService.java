package com.habitine.developers.habtapi.modules.user.services;

import com.habitine.developers.habtapi.modules.user.repositories.UserRepository;
import com.habitine.developers.habtapi.modules.user.usecases.UserVerificationUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitine.developers.habtapi.modules.user.exceptions.UserAlreadyExistsException;

@Service
public class UserVerificationService implements UserVerificationUseCases {
   @Autowired
   private UserRepository userRepository;

   public void verifyIfEmailIsInUse(String email) throws UserAlreadyExistsException {
      var user = this.userRepository.findByEmail(email);

      if (user != null) {
         throw new UserAlreadyExistsException("Email is already in use.");
      }
   }

   public void verifyIfUsernameIsInUse(String username) throws UserAlreadyExistsException {
      var user = this.userRepository.findByUsername(username);

      if (user != null) {
         throw new UserAlreadyExistsException("Username is already in use.");
      }
   }
}
