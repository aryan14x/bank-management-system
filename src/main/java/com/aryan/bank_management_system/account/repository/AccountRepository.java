package com.aryan.bank_management_system.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.bank_management_system.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(String accountNumber);

}