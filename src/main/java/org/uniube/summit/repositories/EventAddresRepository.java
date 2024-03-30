package org.uniube.summit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Category;
import org.uniube.summit.domain.EventAddres;

import java.util.List;
@Repository
public class EventAddresRepository {
    @Autowired
    private EventAddresRepositoryJPA repositoryJPA;

    public List<EventAddres>findAll(){
        return repositoryJPA.findAll();
    }

    public EventAddres get(Long id){
        return repositoryJPA.findById(id).orElse(null);
    }

    public EventAddres save(EventAddres eventAddres){
        return repositoryJPA.save(eventAddres);
    }

    public void deleteById(Long id){
        repositoryJPA.deleteById(id);
    }

    public EventAddres update(EventAddres eventAddres){
        if(eventAddres.getId() != null && repositoryJPA.existsById(eventAddres.getId())){
            return repositoryJPA.save(eventAddres);
        } else {
            throw new IllegalArgumentException("Identificador deve ser nulo para operação de atualização!");
        }
    }

}
