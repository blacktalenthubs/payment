package com.api.service.api_service_devlop.repository;

import com.api.service.api_service_devlop.models.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, UUID> {
    List<PaymentMethod> findByAccountId(UUID accountId);
}
