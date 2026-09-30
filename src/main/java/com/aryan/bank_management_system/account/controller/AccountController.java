package com.aryan.bank_management_system.account.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.service.AccountService;
import com.aryan.bank_management_system.account.transaction.entity.Transaction;
import com.aryan.bank_management_system.account.transaction.service.TransactionService;
import com.aryan.bank_management_system.entity.Customer;
import com.aryan.bank_management_system.repository.CustomerRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CustomerRepository customerRepository;
    private final TransactionService transactionService;

    public AccountController(
            AccountService accountService,
            CustomerRepository customerRepository,
            TransactionService transactionService) {

        this.accountService = accountService;
        this.customerRepository = customerRepository;
        this.transactionService = transactionService;
    }

    // Create Account
    @PostMapping
    public Account createAccount(
            @Valid @RequestBody Account account,
            @RequestParam Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        account.setCustomer(customer);

        return accountService.createAccount(account);
    }

    // Get All Accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Get Account By ID
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Get Account Transactions
    @GetMapping("/{id}/transactions")
    public List<Transaction> getAccountTransactions(
            @PathVariable Long id) {

        return transactionService.getTransactionsByAccount(id);
    }

    // Update Account
    @PutMapping("/{id}")
    public Account updateAccount(
            @PathVariable Long id,
            @Valid @RequestBody Account account) {

        return accountService.updateAccount(id, account);
    }
}