package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.EventAddresEntity;
import org.uniube.summit.repositories.jpa.EventAddresRepositoryJPA;

import java.util.List;
@Repository
public class EventAddresRepository {
    @Autowired
    private EventAddresRepositoryJPA repositoryJPA;

    public List<EventAddresEntity>findAll(){
        return repositoryJPA.findAll();
    }

    public EventAddresEntity get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }

    public EventAddresEntity save(EventAddresEntity eventAddres){
        return repositoryJPA.save(eventAddres);
    }

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public EventAddresEntity update(EventAddresEntity eventAddres){
        if(eventAddres.getId() != null && repositoryJPA.existsById(eventAddres.getId())){
            return repositoryJPA.save(eventAddres);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }

}
