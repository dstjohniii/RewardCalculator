package com.poc.reward.calculator.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;
import com.poc.reward.calculator.mapper.TransactionToCustomTransactionDTOMapper;
import com.poc.reward.calculator.service.RewardCalculatorService;
import com.poc.reward.calculator.service.dao.TransactionRepository;
import com.poc.reward.calculator.type.Transaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RewardCalculatorServiceImpl implements RewardCalculatorService {

	TransactionRepository transactionRepository;
	TransactionToCustomTransactionDTOMapper transactionToCustomTransactionDTOMapper;
	
	@Override
	public List<CustomerTransactionDTO> getAllCustomerTransactions() {
		return transactionRepository.findAll().stream()
			.map(this::convertToCustomerTransactionDTO)
			.toList();
	}
	
	private CustomerTransactionDTO convertToCustomerTransactionDTO(Transaction transactions) {
		return transactionToCustomTransactionDTOMapper.transactionToCustomTransactionDTOMapper(transactions);
	}
}
