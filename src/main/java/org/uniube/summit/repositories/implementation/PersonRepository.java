package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Credential;
import org.uniube.summit.domain.Person;
import org.uniube.summit.repositories.jpa.PersonRepositoryJPA;

import java.util.List;

@Repository
public class PersonRepository {
    @Autowired
    private PersonRepositoryJPA repositoryJPA;
    public List<Person> findAll(){

        return repositoryJPA.findAll();
    }

    public Person findByCredential(Credential credential){
        try {
            return repositoryJPA.findByCredential(credential.getUsername(), credential.getPassword());

        } catch (Exception exception){
            return null;
        }

    }
}
