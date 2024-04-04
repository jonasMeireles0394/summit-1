package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.Category;
import org.uniube.summit.domain.Image;
import org.uniube.summit.services.ImageService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService service;
    @GetMapping
    public @ResponseBody List<Image> findAll(){
        return service.findAll();
    }


}
