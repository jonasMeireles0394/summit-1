package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.CredentialEntity;
import org.uniube.summit.repositories.entities.PersonEntity;
import org.uniube.summit.repositories.jpa.PersonRepositoryJPA;

import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    private PersonRepositoryJPA repositoryJPA;
    public List<PersonEntity> findAll(){

        return repositoryJPA.findAll();
    }

    public PersonEntity findByCredential(CredentialEntity credential){
        try {
            return repositoryJPA.findByCredential(credential.getUsername(), credential.getPassword());

        } catch (Exception exception){
            return null;
        }

    }

    public PersonEntity get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }

    public PersonEntity save(PersonEntity event){
        return repositoryJPA.save(event);
    }

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public PersonEntity update(PersonEntity user){
        if (user.getId() != null && repositoryJPA.existsById(user.getId())){
            return repositoryJPA.save(user);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }
}