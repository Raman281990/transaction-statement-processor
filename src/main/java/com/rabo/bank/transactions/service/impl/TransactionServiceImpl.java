package com.rabo.bank.transactions.service.impl;

import com.rabo.bank.transactions.service.CSVGeneratorService;
import com.rabo.bank.transactions.service.TransactionService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private CSVGeneratorService csvGeneratorService;

    /**
     * processTransactionStatements runs the job for processing transaction statements and
     * calls CSV generation service to generate report of the failed records.
     *
     * @return
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    @Override
    public ByteArrayOutputStream processTransactionStatements() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, params);
        return csvGeneratorService.createReportForFailedRecords(jobExecution);

    }


}
