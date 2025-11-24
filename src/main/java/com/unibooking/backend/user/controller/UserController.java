package com.unibooking.backend.user.controller;

import com.unibooking.backend.Exception.UserAlreadyExistsException;
import com.unibooking.backend.Exception.UserNotFoundException;
import com.unibooking.backend.user.dto.LoginDTO;
import com.unibooking.backend.user.dto.RegisterDTO;
import com.unibooking.backend.user.dto.UpdateDTO;
import com.unibooking.backend.user.dto.UserDTO;
import com.unibooking.backend.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get currently logged-in user's profile (email from JWT)
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUserProfile() throws UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // this comes from JWT subject / UserDetails username

        UserDTO userDTO = userService.getUserProfile(email);
        return ResponseEntity.ok(userDTO);
    }


    // Get all users (ADMIN only)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Update user details
    @PutMapping("/update")
    public ResponseEntity<String> updateUserProfile(@RequestBody UpdateDTO updateDTO) throws UserNotFoundException {
        userService.updateUserProfile(updateDTO);
        return ResponseEntity.ok("User profile updated successfully!");
    }

    // delete user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User profile deleted successfully!");
    }
}




