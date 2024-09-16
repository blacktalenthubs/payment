package com.api.service.api_service_devlop.repository;


import com.api.service.api_service_devlop.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}