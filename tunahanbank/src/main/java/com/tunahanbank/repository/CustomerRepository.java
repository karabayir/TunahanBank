package com.tunahanbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahanbank.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
