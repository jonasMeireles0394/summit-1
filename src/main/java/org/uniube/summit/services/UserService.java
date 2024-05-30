package org.uniube.summit.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.User;
import org.uniube.summit.repositories.entities.UserEntity;
import org.uniube.summit.repositories.implementation.UserRepository;
import org.uniube.summit.services.mappers.UserMapper;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userRepository.findAll().stream().map(UserMapper::out).toList();
    }

    @Transactional(readOnly = true)
    public User get(Long id){
        return UserMapper.out(userRepository.get(id));
    }

    @Transactional
    public User create(User user){
        if (user.getId() != null) {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        UserEntity entity = UserMapper.in(user);
        return UserMapper.out(userRepository.save(entity));
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(User user){
        if (user.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        UserEntity entity = UserMapper.in(user);
        return UserMapper.out(userRepository.save(entity));
    }
}

