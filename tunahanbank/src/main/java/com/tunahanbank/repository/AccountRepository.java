package com.tunahanbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahanbank.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
