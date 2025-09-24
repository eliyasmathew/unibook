package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.ProviderDTO;

import java.util.List;

public interface ProviderService {
    // Registering new service
    Boolean registerProvider(ProviderDTO providerDTO);
    
    ProviderDTO getProviderByEmail(String providerEmail);

    List<ProviderDTO> getAllProviders();
}
