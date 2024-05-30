package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.User;
import org.uniube.summit.repositories.entities.CredentialEntity;
import org.uniube.summit.repositories.entities.EventEntity;
import org.uniube.summit.repositories.entities.PersonEntity;
import org.uniube.summit.repositories.entities.UserEntity;
import org.uniube.summit.repositories.jpa.EventRepositoryJPA;
import org.uniube.summit.repositories.jpa.UserRepositoryJPA;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    public List<UserEntity> findAll(){
        return userRepositoryJPA.findAll();
    }

    public UserEntity get(Long id){
        return userRepositoryJPA.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity event){
        return userRepositoryJPA.save(event);
    }

    public void deleteById(Long id){
        userRepositoryJPA.deleteById(id);
    }

    public UserEntity update(UserEntity user){
        if (user.getId() != null && userRepositoryJPA.existsById(user.getId())){
            return userRepositoryJPA.save(user);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }
}
