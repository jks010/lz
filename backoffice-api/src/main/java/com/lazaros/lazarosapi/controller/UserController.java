package com.lazaros.lazarosapi.controller;

import com.lazaros.lazarosapi.dto.FormDTO;
import com.lazaros.lazarosapi.dto.UserDTO;
import com.lazaros.lazarosapi.entity.User;
import com.lazaros.lazarosapi.repository.UserRepository;
import com.lazaros.lazarosapi.service.UserService;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return service.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<Any> addUser(@RequestBody FormDTO formDTO){
        try{
            service.addUser(formDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping("/updateUser")
    public ResponseEntity<Any> updateUser(@RequestBody UserDTO userDTO){
        try{
            service.updateUser(userDTO);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Any> addUser(@PathVariable Long id){
        try{
            service.deleteUser(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}
