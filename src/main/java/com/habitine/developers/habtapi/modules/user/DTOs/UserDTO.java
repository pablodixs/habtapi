package com.habitine.developers.habtapi.modules.user.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
   private String username;
   private String displayName;
   private String email;
   private String password;
}
