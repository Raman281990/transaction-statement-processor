package com.rabo.bank.transactions.api;

import com.rabo.bank.transactions.service.TransactionService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@ExtendWith(MockitoExtension.class)
public class TransactionApiTest {

    @InjectMocks
    TransactionApi TransactionApi;

    @Mock
    TransactionService transactionService;

    @Test
    public void testTransactionApi() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        Mockito.when(transactionService.processTransactionStatements()).thenReturn(new ByteArrayOutputStream());
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ResponseEntity responseEntity = TransactionApi.process(response);
        Assert.assertNotNull(responseEntity);
        Assert.assertNotNull(responseEntity.getBody());
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
