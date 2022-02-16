package com.example.restfulwebservice.user;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

//    @GetMapping("/login")
//    public String userlogin(){
//
//        return index.html;
//    }

    private final UserDaoService service;

    public UserController(UserDaoService service) {

        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {

        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id) {

        User user = service.findone(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] Not Found", id));
        }
        return user;

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/userdelete/{id}")
    public void userdelete(@PathVariable int id){

        User user = service.deleteuser(id);

        if (user == null){
            throw new UserNotFoundException(String.format("ID[%s] Not Found", id));
        }
//        else if (user.getId() == id){
//            throw new
//
//        }



    }






}
