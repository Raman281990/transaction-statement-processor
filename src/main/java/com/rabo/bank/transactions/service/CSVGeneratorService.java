package com.rabo.bank.transactions.service;

import org.springframework.batch.core.JobExecution;

import java.io.ByteArrayOutputStream;

public interface CSVGeneratorService {
    ByteArrayOutputStream createReportForFailedRecords(JobExecution jobExecution);
}
