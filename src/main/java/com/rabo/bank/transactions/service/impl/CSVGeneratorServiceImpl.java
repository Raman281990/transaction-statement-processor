package com.rabo.bank.transactions.service.impl;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.rabo.bank.transactions.common.TransactionConstants;
import com.rabo.bank.transactions.ds.FailedRecord;
import com.rabo.bank.transactions.exception.CSVGenerationException;
import com.rabo.bank.transactions.service.CSVGeneratorService;
import org.springframework.batch.core.JobExecution;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * CSVGeneratorService
 *
 * is used for generating CSV data
 */
@Service
public class CSVGeneratorServiceImpl implements CSVGeneratorService {

    /**createReportForFailedRecords
     * generates the CSV records for the invalid transaction records.
     *
     */
    public ByteArrayOutputStream createReportForFailedRecords(JobExecution jobExecution) {

        try {
            List<FailedRecord> failedRecords = (List<FailedRecord>) jobExecution
                    .getExecutionContext()
                    .get(TransactionConstants.FAILED_RECORDS);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os);

            StatefulBeanToCsv<FailedRecord> beanWriter = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanWriter.write(failedRecords);
            writer.close();
            return os;

        } catch (CsvDataTypeMismatchException |
                CsvRequiredFieldEmptyException | IOException ex) {
            throw new CSVGenerationException("CSV Generation failed", ex);
        }
    }
}
