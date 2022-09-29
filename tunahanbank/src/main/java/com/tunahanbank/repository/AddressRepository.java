package com.tunahanbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahanbank.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
