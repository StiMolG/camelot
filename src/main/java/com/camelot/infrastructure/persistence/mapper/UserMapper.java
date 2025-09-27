package com.camelot.infrastructure.persistence.mapper;

import com.camelot.domain.model.User;
import com.camelot.domain.model.UserId;
import com.camelot.infrastructure.persistence.entity.UserEntity;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public class UserMapper{

    public UserEntity toEntity(User user){
        if (user == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(user.getId().value());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRoles(user.getRoles());
        return entity;
    }

    public User toDomain(UserEntity entity){
        if (entity == null) {
            return null;
        }
        return new User(
                new UserId( entity.getId()),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles()
        );
    }
}
