package com.rabo.bank.transactions.batch.writer;

import com.rabo.bank.transactions.data.TransactionStatementRepository;
import com.rabo.bank.transactions.data.entity.TransactionStatement;
import com.rabo.bank.transactions.ds.Records;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordWriter implements ItemWriter<Records> {


    @Autowired
    private TransactionStatementRepository transactionStatementRepository;

    /**
     * write method writes the valid records to the database
     *
     * @param list
     */
    @Override
    public void write(List<? extends Records> list) {

        List<TransactionStatement> records = ((List<Records>) list).stream()
                .flatMap(l -> l.getRecord().stream())
                .map(r -> new TransactionStatement().getTransactionStatement(r))
                .collect(Collectors.toList());

        transactionStatementRepository.saveAll(records);

    }

}
