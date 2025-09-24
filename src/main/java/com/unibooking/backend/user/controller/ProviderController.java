package com.unibooking.backend.user.controller;

import com.unibooking.backend.user.dto.ProviderDTO;
import com.unibooking.backend.user.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;


    // Register a new service (business/organisation)
    @PostMapping("/register")
    public ResponseEntity<ProviderDTO> registerService(@RequestBody ProviderDTO providerDTO) {
        providerService.registerProvider(providerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Get service details by ID
    @GetMapping("/{serviceId}")
    public ResponseEntity<ProviderDTO> getServiceDetails(@RequestParam String email) {
        return ResponseEntity.ok(providerService.getProviderByEmail(email));
    }

    // List all services
    // todo add filter by location
    @GetMapping
    public ResponseEntity<List<ProviderDTO>> getAllServices() {
        return ResponseEntity.ok(providerService.getAllProviders());
    }
}

