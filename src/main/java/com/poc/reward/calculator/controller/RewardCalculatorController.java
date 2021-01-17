package com.poc.reward.calculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;
import com.poc.reward.calculator.service.RewardCalculatorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RewardCalculatorController {

	private final RewardCalculatorService rewardCalculatorService;
	
	@GetMapping("/")
	public String index() {
		return "Home";
	}
//		A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
//	(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
//		Given a record of every transaction during a three month period, 
	// calculate the reward points earned for each customer per month and total.
//		Make up a data set to best demonstrate your solution

	@GetMapping("/transactions")
	@ResponseBody
	public List<CustomerTransactionDTO> getAllTransactions() {
		return rewardCalculatorService.getAllCustomerTransactions();
	}
	
	
	@GetMapping("/calculateRewards")
	public String calculateRewards() {
		
		return "";
	}
	
}
