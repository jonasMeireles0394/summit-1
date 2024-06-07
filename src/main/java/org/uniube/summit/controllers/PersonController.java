package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.Person;
import org.uniube.summit.services.PersonService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public @ResponseBody List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Person get(@PathVariable(name = "id") Long id){
        return personService.get(id);
    }

    @PostMapping
    public @ResponseBody Person create(@RequestBody Person user){
        return personService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable(name = "id") Long id, @RequestBody Person updateUser) {
        updateUser.setId(id);
        return personService.update(updateUser);
    }
}
