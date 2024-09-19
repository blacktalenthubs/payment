package com.api.service.api_service_devlop.service;

import com.api.service.api_service_devlop.models.Account;
import com.api.service.api_service_devlop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        account.setPasswordHash(hashPassword(account.getPasswordHash()));
        return accountRepository.save(account);
    }

    public Account getAccountById(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account updateAccount(UUID accountId, Account updatedAccount) {
        Account existingAccount = getAccountById(accountId);

        existingAccount.setName(updatedAccount.getName());
        existingAccount.setEmail(updatedAccount.getEmail());
        if (!updatedAccount.getPasswordHash().equals(existingAccount.getPasswordHash())) {
            existingAccount.setPasswordHash(hashPassword(updatedAccount.getPasswordHash()));
        }

        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(UUID accountId) {
        accountRepository.deleteById(accountId);
    }

    public List<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    private String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}