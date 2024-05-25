package org.uniube.summit.repositories.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.repositories.entities.EventEntity;
import org.uniube.summit.repositories.entities.EventImageEntity;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.repositories.jpa.EventImageRepositoryJPA;
import org.uniube.summit.repositories.jpa.ImageRepositoryJPA;

import java.util.List;

@Repository
public class EventImageRepository {
    @Autowired
    private EventImageRepositoryJPA eventImageRepositoryJPA;
    public List<EventImageEntity> findAll(){
        return eventImageRepositoryJPA.findAll();
    }

    public List<EventImageEntity> findByEvent(Long eventId){
        return eventImageRepositoryJPA.findByEventId(eventId);
    }

    public EventImageEntity get(Long id){
        return eventImageRepositoryJPA.findById(id).orElse(null);
    }

    public EventImageEntity save(EventImageEntity event){
        return eventImageRepositoryJPA.save(event);
    }

    public void deleteById(Long id){
        eventImageRepositoryJPA.deleteById(id);
    }

    public EventImageEntity update(EventImageEntity event){
        if (event.getId() != null && eventImageRepositoryJPA.existsById(event.getId())){
            return eventImageRepositoryJPA.save(event);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }

}
