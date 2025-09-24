package com.unibooking.backend.user.service;

import com.unibooking.backend.Exception.UserAlreadyExistsException;
import com.unibooking.backend.Exception.UserNotFoundException;
import com.unibooking.backend.user.dto.*;
import com.unibooking.backend.user.model.UserModel;
import com.unibooking.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public Optional<UserModel> getCurrentUserProfile(String email) throws UserNotFoundException {
        try{
            return userRepository.findByUserEmail(email);
        }catch(Exception e){
            throw new UserNotFoundException("Unable to fetch user!");
        }
    }

    @Override
    public Boolean createUserProfile(UserDTO userDTO) throws UserAlreadyExistsException{
        if(userRepository.findByUserEmail(userDTO.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("Email already registered: " + userDTO.getEmail());
        }
        UserModel userModel = new UserModel();
        userModel.setUserEmail(userDTO.getEmail());
        userModel.setUserName(userDTO.getName());
        userModel.setUserPhone(userDTO.getPhone());
        UserModel savedUser = userRepository.save(userModel);
        return true;
    }

}
