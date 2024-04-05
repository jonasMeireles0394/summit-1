package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Credential;
import org.uniube.summit.domain.Person;
import org.uniube.summit.repositories.implementation.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    @Transactional(readOnly = true)
    public Person get(Credential credential){
        return repository.findByCredential(credential);
    }
}
