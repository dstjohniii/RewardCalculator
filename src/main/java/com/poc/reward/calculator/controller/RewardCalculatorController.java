package com.poc.reward.calculator.controller;

import java.util.List;

import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
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

	@GetMapping("/transactions")
	@ResponseBody
	public List<CustomerTransactionDTO> getAllTransactions() {
		return rewardCalculatorService.getAllCustomerTransactions();
	}
	
	@GetMapping("/calculate-rewards")
	public String calculateRewards() {
		throw new InvalidEndpointRequestException("Request method is not finished", "Incomplete");
	}
	
}
