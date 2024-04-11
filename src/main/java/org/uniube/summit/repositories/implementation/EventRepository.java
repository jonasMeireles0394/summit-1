package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Event;
import org.uniube.summit.repositories.jpa.EventRepositoryJPA;

import java.util.List;
@Repository
public class EventRepository {

    @Autowired
    private EventRepositoryJPA repositoryJPA;

    public List<Event> findAll(){
        return repositoryJPA.findAll();
    }

    public Event get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }

    public Event save(Event event){
        return repositoryJPA.save(event);
    }

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public Event update(Event event){
        if (event.getId() != null && repositoryJPA.existsById(event.getId())){
            return repositoryJPA.save(event);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }
}
