package com.api.service.api_service_devlop.controllers;

import com.api.service.api_service_devlop.models.Account;
import com.api.service.api_service_devlop.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 1. Create Account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    // 2. Get Account by ID
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }

    // 3. Update Account
    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable UUID accountId, @Valid @RequestBody Account updatedAccount) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, updatedAccount));
    }

    // 4. Delete Account
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    // 5. List all accounts (optional for admin use)
    @GetMapping("/list")
    public ResponseEntity<List<Account>> listAccounts() {
        return ResponseEntity.ok(accountService.listAllAccounts());
    }
}