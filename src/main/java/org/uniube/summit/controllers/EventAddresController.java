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

}
