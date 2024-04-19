package org.uniube.summit.services.mappers;
import org.uniube.summit.domain.Event;
import org.uniube.summit.repositories.entities.EventEntity;

public class EventMapper {
    public static Event out(EventEntity entity){
        if (entity == null){
            return null;
        }
        Event domain = new Event();
        domain.setId(entity.getId());
        domain.setCategoryid(entity.getCategoryid());
        domain.setEventaddressid(entity.getEventaddressid());
        domain.setName(entity.getName());
        domain.setInitialdate(entity.getInitialdate());
        domain.setEnddate(entity.getEnddate());
        domain.setObservation(entity.getObservation());
        domain.setStatus(entity.getStatus());
        return domain;
    }

    public static EventEntity in(Event domain){
        if (domain == null){
            return null;
        }
        EventEntity entity = new EventEntity();
        entity.setId(domain.getId());
        entity.setCategoryid(domain.getCategoryid());
        entity.setEventaddressid(domain.getEventaddressid());
        entity.setName(domain.getName());
        entity.setInitialdate(domain.getInitialdate());
        entity.setEnddate(domain.getEnddate());
        entity.setObservation(domain.getObservation());
        entity.setStatus(domain.getStatus());
        return entity;
    }

}
