package com.example.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
