package com.aryan.bank_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.bank_management_system.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}