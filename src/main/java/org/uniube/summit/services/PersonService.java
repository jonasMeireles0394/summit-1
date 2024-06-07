package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Person;
import org.uniube.summit.repositories.entities.CredentialEntity;
import org.uniube.summit.repositories.entities.PersonEntity;
import org.uniube.summit.repositories.implementation.PersonRepository;
import org.uniube.summit.services.mappers.PersonMapper;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Transactional(readOnly = true)
    public PersonEntity get(CredentialEntity credential){

        return personRepository.findByCredential(credential);
    }
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> findAll(){
        return personRepository.findAll().stream().map(PersonMapper::out).toList();
    }

    @Transactional(readOnly = true)
    public Person get(Long id){
        return PersonMapper.out(personRepository.get(id));
    }

    @Transactional
    public Person create(Person person){
        if (person.getId() != null) {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        PersonEntity entity = PersonMapper.in(person);
        return PersonMapper.out(personRepository.save(entity));
    }

    @Transactional
    public void delete(Long id){
        personRepository.deleteById(id);
    }

    @Transactional
    public Person update(Person user){
        if (user.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        PersonEntity entity = PersonMapper.in(user);
        return PersonMapper.out(personRepository.save(entity));
    }
}