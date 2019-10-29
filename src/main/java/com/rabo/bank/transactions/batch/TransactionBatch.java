package com.rabo.bank.transactions.batch;

import com.rabo.bank.transactions.batch.processor.ValidatorProcessor;
import com.rabo.bank.transactions.batch.reader.XMLRecordReader;
import com.rabo.bank.transactions.batch.writer.RecordWriter;
import com.rabo.bank.transactions.ds.Records;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is the Configuration class for the transaction batch
 */
@Slf4j
@Configuration
public class TransactionBatch {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private XMLRecordReader xmlRecordReader;

    @Autowired
    private ValidatorProcessor validatorProcessor;

    @Autowired
    private RecordWriter recordWriter;

    @Bean(name = "processTransactions")
    public Job processTransactions() {
        JobBuilder builder = jobBuilderFactory.get("processTransactions")
                .incrementer(new RunIdIncrementer())
                .listener(new BatchJobCompletionListener());

        return builder.start(xmlStep()).build();
    }

    @Bean
    public Step xmlStep() {
        return stepBuilderFactory.get("xmlStep")
                .<Records, Records>chunk(1)
                .reader(xmlRecordReader)
                .processor(validatorProcessor)
                .writer(recordWriter).build();
    }

}
