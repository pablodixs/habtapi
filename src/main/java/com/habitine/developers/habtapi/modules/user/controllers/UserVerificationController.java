package com.habitine.developers.habtapi.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habitine.developers.habtapi.modules.user.services.UserVerificationService;

@RestController
@RequestMapping("/api/verify-availability")
public class UserVerificationController {
   @Autowired
   private UserVerificationService verificationService;

   @GetMapping("/username")
   public ResponseEntity<String> verifyIfUsernameIsInUse(@RequestParam("id") String username) {
      verificationService.verifyIfUsernameIsInUse(username);

      return ResponseEntity.ok().body("Username available.");
   }

   @GetMapping("/email")
   public ResponseEntity<String> verifyIfEmailIsInUse(@RequestParam("id") String email) {
      verificationService.verifyIfEmailIsInUse(email);

      return ResponseEntity.ok().body("Email is not in use.");
   }
}
