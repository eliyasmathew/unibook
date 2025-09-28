package com.unibooking.backend.user.service;

import com.unibooking.backend.Exception.UserAlreadyExistsException;
import com.unibooking.backend.user.dto.*;
import com.unibooking.backend.user.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {

    // Get logged-in user's profile
    Optional<UserModel> getCurrentUserProfile(String email);

    // register new user
    Boolean createUserProfile(UserDTO userDTO) throws UserAlreadyExistsException;
}
