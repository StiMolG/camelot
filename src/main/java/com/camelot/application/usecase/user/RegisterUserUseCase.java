package com.camelot.application.usecase.user;

import com.camelot.domain.model.User;
import com.camelot.domain.repository.UserRepository;

public class RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
