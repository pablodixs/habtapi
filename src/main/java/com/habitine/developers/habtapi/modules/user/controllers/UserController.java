package com.habitine.developers.habtapi.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.services.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

   @Autowired
   private UserService userService;

   @PostMapping("/user/create")
   public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
       var user = this.userService.createNewUser(userDTO);

       return ResponseEntity.status(HttpStatus.CREATED).body(user);
   }

   @GetMapping("/users")
   public ResponseEntity<Object> listUsers() {
       return ResponseEntity.ok().body(userService.findAllUsers());
   }

   @GetMapping("/user")
   public ResponseEntity<Object> listUserById(@RequestParam("id") UUID id) {
       var user = this.userService.findUserById(id);
       return ResponseEntity.ok().body(user);
   }
}
