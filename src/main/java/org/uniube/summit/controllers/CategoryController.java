package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.Category;
import org.uniube.summit.services.CategoryService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public @ResponseBody List<Category>findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Category get(@PathVariable(name = "id") Long id){
        return service.get(id);
    }

    @PostMapping
    public @ResponseBody Category create(@RequestBody Category category){
        return service.create(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable(name = "id") Long id, @RequestBody Category updatedCategory) {
        updatedCategory.setId(id);
        return service.update(updatedCategory);
    }

}
