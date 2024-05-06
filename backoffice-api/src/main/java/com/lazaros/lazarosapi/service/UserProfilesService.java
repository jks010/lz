package com.lazaros.lazarosapi.service;

import com.lazaros.lazarosapi.dto.UserProfileDTO;
import com.lazaros.lazarosapi.entity.User;
import com.lazaros.lazarosapi.entity.UserProfiles;
import com.lazaros.lazarosapi.exception.CustomException;
import com.lazaros.lazarosapi.repository.UserProfilesRepository;
import com.lazaros.lazarosapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserProfilesService {

    @Autowired
    private UserProfilesRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<UserProfileDTO> getUserProfiles(Long id){
        List<UserProfiles> userProfilesList = repository.findByUserId(id);
        List<UserProfileDTO> userProfileDTOSList = new java.util.ArrayList<>(Collections.emptyList());
        for (UserProfiles userProfile: userProfilesList){
            userProfileDTOSList.add(new UserProfileDTO(userProfile.getId(), userProfile.getDescription()));
        }
        return userProfileDTOSList;
    }

    public void addUserProfile(UserProfileDTO up) throws Exception {
        if (up.getDescription().length() < 5) {
            throw new Exception("Description too short");
        }
        User user = userRepository.findById(up.getUserId()).orElseThrow();
        UserProfiles newUserProfile = new UserProfiles(up.getDescription(), user);
        repository.save(newUserProfile);
    }

    public void updateUserProfile(UserProfileDTO up) throws Exception {
        if (up.getDescription().length() < 5) {
            throw new Exception("Description too short");
        }
        userRepository.findById(up.getUserId()).orElseThrow();
        UserProfiles userProfileToUpdate = repository.findById(up.getId()).orElseThrow();
        userProfileToUpdate.setDescription(up.getDescription());
        repository.save(userProfileToUpdate);
    }

    public void deleteUserProfile(Long id) throws CustomException{
        UserProfiles userProfiles = repository.findById(id).orElseThrow();
        if(repository.findByUserId(userProfiles.getUser().getId()).size()<2){
            throw new CustomException("Obrigatório ter no mínimo 1 perfil.");
        }
        repository.deleteById(id);
    }

    public void deleteByUserId(Long userId){
        repository.deleteByUserId(userId);
    }

}
