package com.poc.reward.calculator.service;

import java.util.List;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;

public interface RewardCalculatorService {

	List<CustomerTransactionDTO> getAllCustomerTransactions();
}
