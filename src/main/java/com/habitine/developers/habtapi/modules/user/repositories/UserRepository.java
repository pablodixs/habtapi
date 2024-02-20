package com.habitine.developers.habtapi.modules.user.repositories;

import java.util.List;
import java.util.UUID;

import com.habitine.developers.habtapi.modules.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findByEmailOrUsername(String email, String username);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
