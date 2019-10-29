package com.rabo.bank.transactions.data;

import com.rabo.bank.transactions.data.entity.TransactionStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatementRepository extends JpaRepository<TransactionStatement, String> {


}
