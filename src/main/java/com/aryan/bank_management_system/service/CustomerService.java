package com.aryan.bank_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aryan.bank_management_system.account.entity.Account;
import com.aryan.bank_management_system.account.repository.AccountRepository;
import com.aryan.bank_management_system.entity.Customer;
import com.aryan.bank_management_system.exception.ResourceNotFoundException;
import com.aryan.bank_management_system.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            AccountRepository accountRepository) {

        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    // Create Customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer By ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));
    }

    // Update Customer
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());

        return customerRepository.save(existingCustomer);
    }

    // Get Customer Accounts
    public List<Account> getCustomerAccounts(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        return accountRepository.findAll()
                .stream()
                .filter(account ->
                        account.getCustomer() != null
                        && account.getCustomer().getId().equals(customer.getId()))
                .toList();
    }
}