package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.Event;
import org.uniube.summit.services.EventService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public @ResponseBody List<Event>findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Event get(@PathVariable(name = "id") Long id){
        return service.get(id);
    }

    @PostMapping
    public @ResponseBody Event create(@RequestBody Event event){
        return service.create(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable(name = "id") Long id, @RequestBody Event updateEvent) {
        updateEvent.setId(id);
        return service.update(updateEvent);
    }

}
