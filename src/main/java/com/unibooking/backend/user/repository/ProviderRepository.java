package com.unibooking.backend.user.repository;

import com.unibooking.backend.user.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<ProviderModel, Long> {
    Optional<ProviderModel> findByProviderEmail(String providerEmail);
}
