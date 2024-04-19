package org.uniube.summit.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Event;
import org.uniube.summit.repositories.entities.EventEntity;
import org.uniube.summit.repositories.implementation.EventRepository;
import org.uniube.summit.services.mappers.EventMapper;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    @Transactional(readOnly = true)
    public List<Event>findAll(){

        return repository.findAll().stream().map(EventMapper::out).toList();
    }

    @Transactional(readOnly = true)
    public Event get(Long id){

        return EventMapper.out(repository.get(id));
    }

    @Transactional
    public Event create(Event event){
        if (event.getId() != null) {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        EventEntity entity = EventMapper.in(event);
        return EventMapper.out(repository.save(entity));
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Event update(Event event){
        if (event.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        EventEntity entity = EventMapper.in(event);
        return EventMapper.out(repository.save(entity));
    }

}
