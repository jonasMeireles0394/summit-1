package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.EventAddres;;
import org.uniube.summit.repositories.entities.EventAddresEntity;
import org.uniube.summit.repositories.implementation.EventAddresRepository;
import org.uniube.summit.services.mappers.EventAddressMapper;

import java.util.List;

@Service
public class EventAddresService {
    @Autowired
    private EventAddresRepository repository;

    @Transactional(readOnly = true)
    public List<EventAddres> findAll(){
        return repository.findAll().stream().map(EventAddressMapper::out).toList();
    }

    @Transactional(readOnly = true)
    public EventAddres get(Long id){
        return EventAddressMapper.out(repository.get(id));
    }

    @Transactional
    public EventAddres create(EventAddres eventAddres){
        if(eventAddres.getId() != null){
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        EventAddresEntity entity = EventAddressMapper.in(eventAddres);
        return EventAddressMapper.out(repository.save(entity));
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public EventAddres update(EventAddres eventAddres){
        if(eventAddres.getId() == null){
            throw new IllegalArgumentException("Identificador deve ser fornecido para operação de atualização!");
        }
        EventAddresEntity entity = EventAddressMapper.in(eventAddres);
        return EventAddressMapper.out(repository.save(entity));
    }

}
