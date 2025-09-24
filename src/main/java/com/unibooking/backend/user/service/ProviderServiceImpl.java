package com.unibooking.backend.user.service;

import com.unibooking.backend.Exception.ProviderAlreadyExists;
import com.unibooking.backend.Exception.ProviderNotFoundException;
import com.unibooking.backend.user.dto.ProviderDTO;
import com.unibooking.backend.user.model.ProviderModel;
import com.unibooking.backend.user.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    ProviderRepository providerRepository;


    @Override
    public Boolean registerProvider(ProviderDTO providerDTO) throws ProviderAlreadyExists {
        if(providerRepository.findByProviderEmail(providerDTO.getProviderEmail()).isPresent()){
            throw new ProviderAlreadyExists("Email already registered: " + providerDTO.getProviderEmail());
        }
        ProviderModel providerModel = new ProviderModel();
        providerModel.setProviderName(providerDTO.getProviderName());
        providerModel.setProviderEmail(providerDTO.getProviderEmail());
        providerModel.setProviderPassword(providerDTO.getProviderPassword());
        providerModel.setProviderPhone(providerDTO.getProviderPhone());
        providerModel.setProviderBusinessName(providerDTO.getProviderBusinessName());
        providerModel.setProviderCategory(providerDTO.getProviderCategory());
        providerModel.setProviderAddress(providerDTO.getProviderAddress());
        providerModel.setProviderLocation(providerDTO.getProviderLocation());
        providerModel.setProviderDescription(providerDTO.getProviderDescription());
        ProviderModel saved = providerRepository.save(providerModel);
        return true;
    }

    @Override
    public ProviderDTO getProviderByEmail(String providerEmail) throws ProviderNotFoundException {
            return providerRepository.findByProviderEmail(providerEmail)
                    .map(provider -> new ProviderDTO(
                            provider.getProviderId(),
                            provider.getProviderAddress(),
                            provider.getProviderCreatedAt(),
                            provider.getProviderDescription(),
                            provider.getProviderEmail(),
                            provider.getProviderLocation(),
                            provider.getProviderCategory(),
                            provider.getProviderBusinessName(),
                            provider.getProviderPhone(),
                            provider.getProviderPassword(),
                            provider.getProviderName()
                    )).orElseThrow(() -> new ProviderNotFoundException("Service not found"));
    }

    @Override
    public List<ProviderDTO> getAllProviders() {
        try {
            return providerRepository.findAll().stream()
                    .map(provider -> new ProviderDTO(
                            provider.getProviderId(),
                            provider.getProviderName(),
                            provider.getProviderEmail(),
                            provider.getProviderPassword(),
                            provider.getProviderPhone(),
                            provider.getProviderBusinessName(),
                            provider.getProviderCategory(),
                            provider.getProviderAddress(),
                            provider.getProviderLocation(),
                            provider.getProviderDescription(),
                            provider.getProviderCreatedAt()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
