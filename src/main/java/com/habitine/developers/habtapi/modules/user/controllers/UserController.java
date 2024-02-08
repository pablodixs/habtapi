package com.habitine.developers.habtapi.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping("/create")
   public String createUser(@RequestBody UserDTO userDTO) {

      userService.createNewUser(userDTO);

      return "Usuário criado";
   }

   @GetMapping
   public String listUsers() {
      return "Sucesso.";
   }
}
