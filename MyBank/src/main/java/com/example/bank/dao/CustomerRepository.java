package com.example.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
}
