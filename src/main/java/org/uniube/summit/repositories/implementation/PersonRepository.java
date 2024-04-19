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
}
