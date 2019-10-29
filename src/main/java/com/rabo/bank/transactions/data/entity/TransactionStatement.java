package com.rabo.bank.transactions.data.entity;

import com.opencsv.bean.CsvBindByName;
import com.rabo.bank.transactions.ds.Records;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class TransactionStatement extends BaseEntity implements Serializable {

    @Column(name = "description")
    private String description;

    @Column(name = "transactionId")
    private Long transactionId;

    @Column(name = "accountNumber")
    protected String accountNumber;

    @Column(name = "startBalance")
    protected BigDecimal startBalance;

    @Column(name = "endBalance")
    protected BigDecimal endBalance;

    public  TransactionStatement getTransactionStatement(Records.Record r) {
        this.setAccountNumber(r.getAccountNumber());
        this.setDescription(r.getDescription());
        this.setEndBalance(r.getEndBalance());
        this.setStartBalance(r.getStartBalance());
        this.setTransactionId(r.getReference());
        return this;
    }


}
