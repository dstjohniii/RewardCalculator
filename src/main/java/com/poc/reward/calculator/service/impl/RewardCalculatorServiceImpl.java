package com.poc.reward.calculator.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;
import com.poc.reward.calculator.mapper.TransactionToCustomTransactionDTOMapper;
import com.poc.reward.calculator.service.RewardCalculatorService;
import com.poc.reward.calculator.service.dao.TransactionRepository;
import com.poc.reward.calculator.type.Transaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RewardCalculatorServiceImpl implements RewardCalculatorService {

	private final TransactionRepository transactionRepository;
	private final TransactionToCustomTransactionDTOMapper transactionToCustomTransactionDTOMapper;
	
	@Override
	public List<CustomerTransactionDTO> getAllCustomerTransactions() {
		return StreamSupport.stream(transactionRepository.findAll().spliterator(), false)
			.map(this::convertToCustomerTransactionDTO)
			.collect(Collectors.toList());
		
	}
	
	private CustomerTransactionDTO convertToCustomerTransactionDTO(Transaction transactions) {
		return transactionToCustomTransactionDTOMapper.transactionToCustomTransactionDTOMapper(transactions);
	}
	
}
