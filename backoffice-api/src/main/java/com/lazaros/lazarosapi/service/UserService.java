package com.lazaros.lazarosapi.service;

import com.lazaros.lazarosapi.dto.FormDTO;
import com.lazaros.lazarosapi.dto.UserDTO;
import com.lazaros.lazarosapi.dto.UserProfileDTO;
import com.lazaros.lazarosapi.entity.User;
import com.lazaros.lazarosapi.entity.UserProfiles;
import com.lazaros.lazarosapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProfilesService userProfilesService;

    public List<User> getAllUsers(){
        List<User> userList = (List<User>) repository.findAllByOrderByIdAsc();
        return userList;
    }

    public void addUser(FormDTO formDTO) throws Exception {

        if(formDTO.getName().length()<10){
            throw new Exception("Name too short");
        }
        if(formDTO.getDescription().length()<5){
            throw new Exception("Description too short");
        }
        User newUser = new User(formDTO.getName());
        User savedUser = repository.save(newUser);
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setUserId(savedUser.getId());
        userProfileDTO.setDescription(formDTO.getDescription());
        userProfilesService.addUserProfile(userProfileDTO);
    }

    public void updateUser(UserDTO userToUpdate) throws Exception{
        if(userToUpdate.getName().length()<10){
            throw new Exception("Name too short");
        }
        User user = repository.findById(userToUpdate.getId()).orElseThrow(EntityNotFoundException::new);
        user.setName(userToUpdate.getName());
        repository.save(user);
    }

    public void deleteUser(Long id){

        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        userProfilesService.deleteByUserId(id);
        repository.deleteById(user.getId());
    }

}
