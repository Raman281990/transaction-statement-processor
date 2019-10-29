package com.rabo.bank.transactions.service.impl;

import com.rabo.bank.transactions.service.CSVGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;

    @Mock
    JobLauncher jobLauncher;

    @Mock
    Job job;

    @Mock
    CSVGeneratorService csvGeneratorService;

    @Test
    public void testProcessTransactionStatements() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, IOException {

       Mockito.when(jobLauncher.run(Mockito.any(Job.class),Mockito.any(JobParameters.class))).thenReturn(null);
        Mockito.when(csvGeneratorService.createReportForFailedRecords(Mockito.any(JobExecution.class)))
                .thenReturn(null);

        ByteArrayOutputStream result =  transactionServiceImpl.processTransactionStatements();

    }
}
