package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.repositories.entities.CredentialEntity;
import org.uniube.summit.repositories.entities.PersonEntity;
import org.uniube.summit.services.PersonService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private PersonService service;
    @PostMapping
    public ResponseEntity<String> login(@RequestBody CredentialEntity credential){
        PersonEntity person = service.get(credential);
        if (person == null){
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok("123456");
    }

}
