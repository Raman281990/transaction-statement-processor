package com.rabo.bank.transactions.api;

import com.rabo.bank.transactions.service.TransactionService;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/transaction-statements")
public class TransactionApi {

    @Autowired
    TransactionService transactionService;

    /**
     * Transaction API processes Transaction statement from a XML files, stores the valid records and
     * generates error report of invalid records in form of CSV data.
     *
     * @param response
     * @return
     * @throws JobInstanceAlreadyCompleteException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobParametersInvalidException
     * @throws JobRestartException
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public ResponseEntity process(HttpServletResponse response) throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException
            , JobParametersInvalidException, JobRestartException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "content-disposition, Content-Type");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + "report_failed_Records.csv");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

        ByteArrayOutputStream out = transactionService.processTransactionStatements();

        return new ResponseEntity(out.toByteArray(), headers, HttpStatus.OK);
    }


}
