package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.Event;
import org.uniube.summit.domain.Image;
import org.uniube.summit.repositories.entities.ImageEntity;
import org.uniube.summit.services.ImageService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService service;
    @GetMapping
    public @ResponseBody List<ImageEntity> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Image get(@PathVariable(name = "id") Long id){
        return service.get(id);
    }

    @PostMapping
    public @ResponseBody Image create(@RequestBody Image image){
        return service.create(image);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Image update(@PathVariable(name = "id") Long id, @RequestBody Image updateImage) {
        updateImage.setId(id);
        return service.update(updateImage);
    }

}
