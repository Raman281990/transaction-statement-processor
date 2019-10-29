package com.rabo.bank.transactions.batch.processor;

import com.rabo.bank.transactions.ds.Records;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.item.ExecutionContext;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class ValidationProcessorTest {

    @InjectMocks
    ValidatorProcessor validatorProcessor;

    @Mock
    JobExecution jobExecution;

    @Test
    public void testProcessRecords() {

        Mockito.when(jobExecution.getExecutionContext()).thenReturn(new ExecutionContext());

        Records records = new Records();
        Records.Record record = new Records.Record();
        record.setReference(123L);
        record.setStartBalance(BigDecimal.valueOf(123L));
        record.setMutation(BigDecimal.valueOf(+10));
        record.setEndBalance(BigDecimal.valueOf(133L));
        records.getRecord().add(record);
        Records.Record record1 = new Records.Record();
        record1.setReference(124L);
        record1.setStartBalance(BigDecimal.valueOf(123L));
        record1.setMutation(BigDecimal.valueOf(-10));
        record1.setEndBalance(BigDecimal.valueOf(113L));
        records.getRecord().add(record1);

        Records result =  validatorProcessor.process(records);
        Assert.assertNotNull(result);
        Assert.assertEquals(2,result.getRecord().size());

    }

    @Test
    public void testProcessRecordsForDuplicateReferenceId() {

        Mockito.when(jobExecution.getExecutionContext()).thenReturn(new ExecutionContext());

        Records records = new Records();
        Records.Record record = new Records.Record();
        record.setReference(123L);
        record.setStartBalance(BigDecimal.valueOf(123L));
        record.setMutation(BigDecimal.valueOf(+10));
        record.setEndBalance(BigDecimal.valueOf(133L));
        records.getRecord().add(record);
        Records.Record record1 = new Records.Record();
        record1.setReference(123L);
        record1.setStartBalance(BigDecimal.valueOf(123L));
        record1.setMutation(BigDecimal.valueOf(-10));
        record1.setEndBalance(BigDecimal.valueOf(113L));
        records.getRecord().add(record1);

        Records result =  validatorProcessor.process(records);
        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.getRecord().size());

    }

    @Test
    public void testProcessRecordsForInvalidEndBalance() {

        Mockito.when(jobExecution.getExecutionContext()).thenReturn(new ExecutionContext());

        Records records = new Records();
        Records.Record record = new Records.Record();
        record.setReference(123L);
        record.setStartBalance(BigDecimal.valueOf(123L));
        record.setMutation(BigDecimal.valueOf(+10));
        record.setEndBalance(BigDecimal.valueOf(133L));
        records.getRecord().add(record);
        Records.Record record1 = new Records.Record();
        record1.setReference(124L);
        record1.setStartBalance(BigDecimal.valueOf(123L));
        record1.setMutation(BigDecimal.valueOf(-10));
        record1.setEndBalance(BigDecimal.valueOf(163L));
        records.getRecord().add(record1);

        Records result =  validatorProcessor.process(records);
        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.getRecord().size());

    }
}
