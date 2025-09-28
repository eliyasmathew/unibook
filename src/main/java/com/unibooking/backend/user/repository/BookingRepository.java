package com.unibooking.backend.user.repository;

import com.unibooking.backend.user.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
    List<BookingModel> findByEmailId(String emailId);
    List<BookingModel> findByProviderId(Long providerId);
}