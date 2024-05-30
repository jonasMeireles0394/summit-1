package org.uniube.summit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uniube.summit.domain.User;
import org.uniube.summit.services.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody User get(@PathVariable(name = "id") Long id){
        return userService.get(id);
    }

    @PostMapping
    public @ResponseBody User create(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable(name = "id") Long id, @RequestBody User updateUser) {
        updateUser.setId(id);
        return userService.update(updateUser);
    }
}
