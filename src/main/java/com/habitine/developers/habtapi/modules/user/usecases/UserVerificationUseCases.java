package com.habitine.developers.habtapi.modules.user.usecases;

public interface UserVerificationUseCases {
    void verifyIfEmailIsInUse(String email);

    void verifyIfUsernameIsInUse(String username);
}
