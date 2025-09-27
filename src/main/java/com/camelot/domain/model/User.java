package com.camelot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UserId id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
