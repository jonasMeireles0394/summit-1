package org.uniube.summit.services.mappers;
import org.uniube.summit.domain.EventAddres;
import org.uniube.summit.repositories.entities.EventAddresEntity;

public class EventAddressMapper {
    public static EventAddres out(EventAddresEntity entity){
        if (entity == null){
            return null;
        }
        EventAddres domain = new EventAddres();
        domain.setId(entity.getId());
        domain.setCity(entity.getCity());
        domain.setComplement(entity.getComplement());
        domain.setDistrict(entity.getDistrict());
        domain.setNumber(entity.getNumber());
        domain.setPlace(entity.getPlace());
        domain.setUf(entity.getUf());
        domain.setZipCode(entity.getZipCode());
        return domain;
    }

    public static EventAddresEntity in(EventAddres domain){
        if (domain == null){
            return null;
        }
        EventAddresEntity entity = new EventAddresEntity();
        entity.setId(domain.getId());
        entity.setCity(domain.getCity());
        entity.setComplement(domain.getComplement());
        entity.setDistrict(domain.getDistrict());
        entity.setNumber(domain.getNumber());
        entity.setPlace(domain.getPlace());
        entity.setUf(domain.getUf());
        entity.setZipCode(domain.getZipCode());
        return entity;
    }
    
}
