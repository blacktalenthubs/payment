package com.api.service.api_service_devlop.controllers;

import com.api.service.api_service_devlop.models.PaymentMethod;
import com.api.service.api_service_devlop.service.PaymentMethodService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment-methods")
@RequiredArgsConstructor
@Validated
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @PostMapping("/add")
    public ResponseEntity<PaymentMethod> addPaymentMethod(@Valid @RequestBody PaymentMethod paymentMethod) {
        return ResponseEntity.ok(paymentMethodService.addPaymentMethod(paymentMethod));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<PaymentMethod>> getPaymentMethods(@PathVariable UUID accountId) {
        return ResponseEntity.ok(paymentMethodService.getPaymentMethods(accountId));
    }

    @PutMapping("/{paymentMethodId}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(
            @PathVariable UUID paymentMethodId, @Valid @RequestBody PaymentMethod updatedPaymentMethod) {
        return ResponseEntity.ok(paymentMethodService.updatePaymentMethod(paymentMethodId, updatedPaymentMethod));
    }

    @DeleteMapping("/{paymentMethodId}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable UUID paymentMethodId) {
        paymentMethodService.deletePaymentMethod(paymentMethodId);
        return ResponseEntity.noContent().build();
    }
}
