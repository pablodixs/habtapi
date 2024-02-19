package com.habitine.developers.habtapi.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.services.UserService;

import jakarta.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @PostMapping("/create")
   public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO) {
      var user = this.userService.createNewUser(userDTO);

      return ResponseEntity.status(HttpStatus.CREATED).body(user);
   }

   @GetMapping("/list-all")
   public ResponseEntity<Object> listUsers() {
      return ResponseEntity.ok().body(userService.findAllUsers());
   }

   @GetMapping
   public ResponseEntity<Object> listUserById(@RequestParam("id") UUID id) {
      var user = this.userService.findUserById(id);
      return ResponseEntity.ok().body(user);
   }
}
