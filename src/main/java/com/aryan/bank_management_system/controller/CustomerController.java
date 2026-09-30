package com.aryan.bank_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.entity.Customer;
import com.aryan.bank_management_system.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create Customer

    @PostMapping
    public Customer createCustomer(
            @Valid @RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    // Get All Customers

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get Customer By ID

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Get Customer Accounts

    @GetMapping("/{id}/accounts")
    public List<Account> getCustomerAccounts(@PathVariable Long id) {
        return customerService.getCustomerAccounts(id);
    }

    // Update Customer

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }
}