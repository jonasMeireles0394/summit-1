package org.uniube.summit.services.mappers;

import org.uniube.summit.domain.User;
import org.uniube.summit.repositories.entities.UserEntity;

public class UserMapper {
    public static User out(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getUsername());
        // Mapeie outros campos conforme necessário
        return user;
    }

    public static UserEntity in(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setDisplayName(user.getUsername());
        // Mapeie outros campos conforme necessário
        return userEntity;

    }
}