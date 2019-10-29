package com.rabo.bank.transactions.ds;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FailedRecord implements Serializable {

    @CsvBindByName
    private Long referenceId;

    @CsvBindByName
    private String description;
}
