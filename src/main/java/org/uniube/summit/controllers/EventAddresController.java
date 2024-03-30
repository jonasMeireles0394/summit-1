package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.EventAddres;
import org.uniube.summit.services.EventAddresService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/eventaddres")
public class EventAddresController {
    @Autowired
    private EventAddresService service;

    @GetMapping
    public @ResponseBody List<EventAddres>findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody EventAddres get(@PathVariable(name = "id") Long id){
        return service.get(id);
    }

    @PostMapping
    public @ResponseBody EventAddres create(@RequestBody EventAddres eventAddres){
        return service.create(eventAddres);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public EventAddres update(@PathVariable(name = "id") Long id, @RequestBody EventAddres updateEventAddres){
        updateEventAddres.setId(id);
        return service.update(updateEventAddres);
    }
}
