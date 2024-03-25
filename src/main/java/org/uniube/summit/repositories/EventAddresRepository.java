package org.uniube.summit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uniube.summit.domain.Category;
import org.uniube.summit.domain.EventAddres;

import java.util.List;
@Repository
public class EventAddresRepository {
    @Autowired
    private EventAddresRepositoryJPA eventAddresRepositoryJPA;

    public List<EventAddres>findAll(){
        return eventAddresRepositoryJPA.findAll();
    }

}
