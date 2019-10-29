package com.rabo.bank.transactions.batch;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatchJobCompletionListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Batch Job Completed Successfully");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            log.error("Batch Job is failed.");
        }

    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Batch Job Is going to be Executed.");
    }
}
