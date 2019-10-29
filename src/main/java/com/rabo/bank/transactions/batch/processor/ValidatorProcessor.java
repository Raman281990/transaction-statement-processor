package com.rabo.bank.transactions.batch.processor;

import com.rabo.bank.transactions.common.TransactionConstants;
import com.rabo.bank.transactions.ds.FailedRecord;
import com.rabo.bank.transactions.ds.Records;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Validator Processor validates the records
 * * 1) Check for duplicate Reference Id
 * * 2) validates the End balance based on the mutation
 */
@Component
public class ValidatorProcessor implements ItemProcessor<Records, Records> {

    private JobExecution jobExecution;


    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        jobExecution = stepExecution.getJobExecution();
    }

    /**
     * process method validates the records
     * 1) Check for duplicate Reference Id
     * 2) validates the End balance based on the mutation
     *
     * @param record
     * @return
     */
    @Override
    public Records process(Records record) {

        List<Records.Record> records = record.getRecord();
        Set<Long> setReferences = new HashSet<>();

        List<Records.Record> inValidRecords = records.stream()
                .filter(r -> isInValidRecord(setReferences, r))
                .collect(Collectors.toList());

        List<FailedRecord> failedRecords = inValidRecords.stream()
                .map(r -> new FailedRecord(r.getReference(), r.getDescription()))
                .collect(Collectors.toList());

        jobExecution.getExecutionContext().put(TransactionConstants.FAILED_RECORDS, failedRecords);

        record.getRecord().removeAll(inValidRecords);

        return record;
    }

    private boolean isInValidRecord(Set<Long> setReferences, Records.Record r) {
        boolean isValidRecordReference = validateReferences(setReferences,
                r.getReference());
        boolean isValidRecordEndBalance = validateEndBalance(r);
        return !isValidRecordEndBalance || !isValidRecordReference;
    }


    private boolean validateEndBalance(Records.Record record) {
        BigDecimal mutation = record.getMutation();
        BigDecimal startBalance = record.getStartBalance();
        BigDecimal endBalance = startBalance.add(mutation);
        return endBalance.compareTo(record.getEndBalance()) == 0;

    }

    private boolean validateReferences(Set<Long> transactionReferences,
                                       Long referenceId) {
        //Check if Transaction Reference is Unique
        return transactionReferences.add(referenceId);
    }
}
