package org.uniube.summit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniube.summit.domain.Category;
import org.uniube.summit.domain.EventAddres;
import org.uniube.summit.repositories.EventAddresRepository;

import java.util.List;

@Service
public class EventAddresService {
    @Autowired
    private EventAddresRepository repository;

    @Transactional(readOnly = true)
    public List<EventAddres> findAll(){
        return repository.findAll();
    }

}
