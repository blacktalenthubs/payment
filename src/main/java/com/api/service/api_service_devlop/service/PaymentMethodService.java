package com.api.service.api_service_devlop.service;

import com.api.service.api_service_devlop.models.PaymentMethod;
import com.api.service.api_service_devlop.repository.PaymentMethodRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public List<PaymentMethod> getPaymentMethods(UUID accountId) {
        return paymentMethodRepository.findByAccountId(accountId);
    }

    public PaymentMethod updatePaymentMethod(UUID paymentMethodId, PaymentMethod updatedPaymentMethod) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(paymentMethodId);
        if (optionalPaymentMethod.isPresent()) {
            PaymentMethod existingPaymentMethod = optionalPaymentMethod.get();
            existingPaymentMethod.setMethodType(updatedPaymentMethod.getMethodType());
            existingPaymentMethod.setDetails(updatedPaymentMethod.getDetails());
            existingPaymentMethod.setCurrency(updatedPaymentMethod.getCurrency());
            return paymentMethodRepository.save(existingPaymentMethod);
        } else {
            throw new RuntimeException("Payment Method not found");
        }
    }

    public void deletePaymentMethod(UUID paymentMethodId) {
        paymentMethodRepository.deleteById(paymentMethodId);
    }
}
