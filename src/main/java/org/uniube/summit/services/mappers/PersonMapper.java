package org.uniube.summit.services.mappers;

import org.uniube.summit.domain.Person;
import org.uniube.summit.repositories.entities.PersonEntity;

public class PersonMapper {
    public static Person out(PersonEntity entity){
        if (entity == null){
            return null;
        }
        Person domain = new Person();
        domain.setId(entity.getId());
        domain.setImageId(entity.getImageid());
        domain.setUsername(entity.getUsername());
        domain.setProfile(entity.getProfile());
        domain.setDisplayName(entity.getDisplayname());
        domain.setBirthDate(entity.getBirthdate());
        domain.setEmail(entity.getEmail());
        domain.setPassword(entity.getPassword());
        return domain;
    }

    public static PersonEntity in(Person domain){
        if (domain == null){
            return null;
        }
        PersonEntity entity = new PersonEntity();
        entity.setId(domain.getId());
        entity.setImageid(domain.getImageId());
        entity.setUsername(domain.getUsername());
        entity.setProfile(domain.getProfile());
        entity.setDisplayname(domain.getDisplayName());
        entity.setBirthdate(domain.getBirthDate());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        return entity;
    }
    
}
