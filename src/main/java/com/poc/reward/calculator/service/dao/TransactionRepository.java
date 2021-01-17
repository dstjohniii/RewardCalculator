package com.poc.reward.calculator.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.poc.reward.calculator.type.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
