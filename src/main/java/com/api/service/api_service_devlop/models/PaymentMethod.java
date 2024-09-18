package com.api.service.api_service_devlop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import jakarta.validation.constraints.Size;
import java.util.UUID;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentMethodId;

    @NotNull(message = "Account ID is required")
    private UUID accountId;

    @NotBlank(message = "Payment method type is required")
    private String methodType;

    @NotBlank(message = "Payment details are required")
    private String details;

    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a three-letter ISO code")
    private String currency;
}
