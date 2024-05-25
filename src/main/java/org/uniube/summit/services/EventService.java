package org.uniube.summit.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Event;
import org.uniube.summit.domain.EventAddres;
import org.uniube.summit.repositories.entities.EventAddresEntity;
import org.uniube.summit.repositories.entities.EventEntity;
import org.uniube.summit.repositories.entities.EventImageEntity;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.repositories.implementation.EventAddresRepository;
import org.uniube.summit.repositories.implementation.EventImageRepository;
import org.uniube.summit.repositories.implementation.EventRepository;
import org.uniube.summit.repositories.implementation.ImageRepository;
import org.uniube.summit.services.mappers.EventAddressMapper;
import org.uniube.summit.services.mappers.EventMapper;
import org.uniube.summit.services.mappers.ImageMapper;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    @Autowired
    private EventAddresRepository eventAddresRepository;

    @Autowired
    private EventImageRepository eventImageRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public List<Event>findAll(){

        return repository.findAll().stream().map(EventMapper::out).toList();
    }

    public List<Event>findByName(String name){

        return repository.findByName("%"+name+"%").stream().map(EventMapper::out).toList();
    }

    @Transactional(readOnly = true)
    public Event get(Long id){

        //return EventMapper.out(repository.get(id));
        EventEntity eventEntity = repository.get(id);
        Event event = EventMapper.out(eventEntity);
        if(eventEntity.getEventaddressid() != null){
            EventAddresEntity eventAddresEntity = eventAddresRepository.get(eventEntity.getEventaddressid());
            EventAddres eventAddres = EventAddressMapper.out(eventAddresEntity);
            event.setEventaddress(eventAddres);
        }

        List<EventImageEntity> eventImageEntities = eventImageRepository.findByEvent(event.getId());

        for(EventImageEntity ea:eventImageEntities){
            ImageEntity imageEntity = imageRepository.get(ea.getImageid());
            event.getImages().add(ImageMapper.out(imageEntity));
        }

        return event;
    }

    @Transactional
    public Event create(Event event){
        if (event.getId() != null) {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de cadastro!");
        }
        EventEntity eventEntity = EventMapper.in(event);
        EventAddresEntity addresEntity = EventAddressMapper.in(event.getEventaddress());
        if(addresEntity != null){
            addresEntity = eventAddresRepository.save(addresEntity);
            eventEntity.setEventaddressid(addresEntity.getId());
        }
        eventEntity = repository.save(eventEntity);
        if(!event.getImages().isEmpty()){
            List<ImageEntity> imageEntities = event.getImages().stream().map(ImageMapper::in).toList();
            for(ImageEntity imageEntity : imageEntities){
                imageEntity = imageRepository.save(imageEntity);
                EventImageEntity eventImageEntity = new EventImageEntity();
                eventImageEntity.setEventid(eventEntity.getId());
                eventImageEntity.setImageid(imageEntity.getId());
                eventImageEntity = eventImageRepository.save(eventImageEntity);
            }
        }
        return EventMapper.out(eventEntity);
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
        EventEntity eventEntity = EventMapper.in(event);
        EventAddresEntity addresEntity = EventAddressMapper.in(event.getEventaddress());
        if(addresEntity != null){
            addresEntity = eventAddresRepository.save(addresEntity);
            eventEntity.setEventaddressid(addresEntity.getId());
        }
        eventEntity = repository.save(eventEntity);
        return EventMapper.out(eventEntity);
    }

}
