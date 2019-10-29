package com.rabo.bank.transactions.service;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.io.ByteArrayOutputStream;

public interface TransactionService {

    ByteArrayOutputStream processTransactionStatements() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException;
}
