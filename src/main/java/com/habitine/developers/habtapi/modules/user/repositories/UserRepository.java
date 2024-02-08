package com.habitine.developers.habtapi.modules.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habitine.developers.habtapi.modules.user.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
