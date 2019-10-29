package com.rabo.bank.transactions;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Transaction Application for processing the transaction records of Rabo Bank
 * and generating the Error Report for the failed records based on certain validations.
 *
 */
@SpringBootApplication
@EnableBatchProcessing
@Async
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}
