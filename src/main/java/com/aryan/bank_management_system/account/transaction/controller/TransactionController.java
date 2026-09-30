package com.aryan.bank_management_system.account.transaction.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.repository.AccountRepository;
import com.aryan.bank_management_system.account.transaction.entity.Transaction;
import com.aryan.bank_management_system.account.transaction.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountRepository accountRepository;

    public TransactionController(
            TransactionService transactionService,
            AccountRepository accountRepository) {

        this.transactionService = transactionService;
        this.accountRepository = accountRepository;
    }

    // Create Transaction
    @PostMapping
    public Transaction createTransaction(
            @Valid @RequestBody Transaction transaction,
            @RequestParam Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        transaction.setAccount(account);

        return transactionService.createTransaction(transaction);
    }

    // Get All Transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get Transaction By ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
}