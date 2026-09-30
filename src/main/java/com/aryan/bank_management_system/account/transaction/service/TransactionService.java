package com.aryan.bank_management_system.account.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.repository.AccountRepository;
import com.aryan.bank_management_system.account.transaction.entity.Transaction;
import com.aryan.bank_management_system.account.transaction.repository.TransactionRepository;
import com.aryan.bank_management_system.exception.ResourceNotFoundException;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(
            TransactionRepository transactionRepository,
            AccountRepository accountRepository) {

        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    // Create Transaction
    public Transaction createTransaction(Transaction transaction) {

        Account account = transaction.getAccount();

        String type = transaction.getTransactionType();

        // Check Transaction Type
        if (!type.equalsIgnoreCase("DEPOSIT")
                && !type.equalsIgnoreCase("WITHDRAW")) {

            throw new RuntimeException(
                    "Transaction type must be DEPOSIT or WITHDRAW"
            );
        }

        // Deposit
        if (type.equalsIgnoreCase("DEPOSIT")) {

            account.setBalance(
                    account.getBalance() + transaction.getAmount()
            );
        }

        // Withdraw
        else {

            if (transaction.getAmount() > account.getBalance()) {
                throw new RuntimeException("Insufficient balance");
            }

            account.setBalance(
                    account.getBalance() - transaction.getAmount()
            );
        }

        // Save updated account balance
        accountRepository.save(account);

        // Save transaction
        return transactionRepository.save(transaction);
    }

    // Get All Transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get Transaction By ID
    public Transaction getTransactionById(Long id) {

        return transactionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Transaction not found"));
    }

    // Get Transactions By Account
    public List<Transaction> getTransactionsByAccount(Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        return transactionRepository.findByAccount(account);
    }
}