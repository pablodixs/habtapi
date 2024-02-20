package com.habitine.developers.habtapi.modules.user.usecases;

import com.habitine.developers.habtapi.modules.user.DTOs.UserDTO;
import com.habitine.developers.habtapi.modules.user.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserServiceUseCases {
    UserEntity createNewUser(UserDTO userDTO);

    Boolean verifyIfUserAlreadyExists(UserDTO userDTO);

    List<UserEntity> findAllUsers();

    UserEntity findUserById(UUID id);
}
