package com.aryan.bank_management_system.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.repository.AccountRepository;
import com.aryan.bank_management_system.exception.ResourceNotFoundException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create Account
    public Account createAccount(Account account) {

        if (accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new RuntimeException("Account number already exists");
        }

        return accountRepository.save(account);
    }

    // Get All Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get Account By ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));
    }

    // Update Account
    public Account updateAccount(Long id, Account account) {

        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setAccountType(account.getAccountType());
        existingAccount.setBalance(account.getBalance());

        return accountRepository.save(existingAccount);
    }
}