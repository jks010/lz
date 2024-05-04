package com.lazaros.lazarosapi.controller;

import com.lazaros.lazarosapi.dto.FormDTO;
import com.lazaros.lazarosapi.dto.UserDTO;
import com.lazaros.lazarosapi.dto.UserProfileDTO;
import com.lazaros.lazarosapi.entity.User;
import com.lazaros.lazarosapi.entity.UserProfiles;
import com.lazaros.lazarosapi.exception.CustomException;
import com.lazaros.lazarosapi.service.UserProfilesService;
import com.lazaros.lazarosapi.service.UserService;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userProfiles")
public class UserProfileController {

    @Autowired
    private UserProfilesService service;

    @GetMapping("/getAllUserProfiles/{id}")
    public List<UserProfileDTO> getAllUsers(@PathVariable Long id){

        return service.getUserProfiles(id);
    }

    @PostMapping("/addUserProfile")
    public ResponseEntity<Any> addUserProfile(@RequestBody UserProfileDTO userProfileDTO){
        try{
            service.addUserProfile(userProfileDTO);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping("/updateUserProfile")
    public ResponseEntity<Any> updateUser(@RequestBody UserProfileDTO userProfileDTO){
        try{
            service.updateUserProfile(userProfileDTO);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/deleteUserProfile/{id}")
    public ResponseEntity<Any> deleteUserProfile(@PathVariable Long id){
        try{
            service.deleteUserProfile(id);
            return ResponseEntity.ok().build();
        }
        catch(CustomException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}
