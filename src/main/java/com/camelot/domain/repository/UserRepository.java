package com.camelot.domain.repository;

import com.camelot.domain.model.User;
import com.camelot.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findById(UserId id);
    User save(User user);
}
