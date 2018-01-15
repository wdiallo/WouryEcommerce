package com.example.bank.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bank.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	@Query("select o from Operation o where o.account_op.code_ac = :x order by o.date_op desc")
	public Page<Operation> listOperation(@Param("x")String codeAc, Pageable pageable);
	
	
	
}
