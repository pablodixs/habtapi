package com.habitine.developers.habtapi.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.services.UserService;

import java.util.UUID;

@RestController
@RequestMapping
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping("/user/create")
   public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
      try {
         var userAlreadyExists = this.userService.verifyIfUserAlreadyExists(userDTO);

         if(userAlreadyExists) {
            throw new Exception("User with this username or email already exists.");
         }

         var user = this.userService.createNewUser(userDTO);

         return ResponseEntity.status(HttpStatus.CREATED).body(user);

      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   @GetMapping("/users")
   public ResponseEntity<Object> listUsers() {
      return ResponseEntity.ok().body(this.userService.findAllUsers());
   }

   @GetMapping("/user")
   public ResponseEntity<Object> listUserById(@RequestParam("id") UUID id) {
      try {
         var user = this.userService.findUserById(id);

         return ResponseEntity.ok().body(user);
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
   }
}
