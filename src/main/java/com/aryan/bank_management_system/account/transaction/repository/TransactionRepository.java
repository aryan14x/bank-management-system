package com.aryan.bank_management_system.account.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.transaction.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccount(Account account);

}