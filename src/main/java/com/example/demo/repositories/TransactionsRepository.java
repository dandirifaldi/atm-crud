package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Transaction;

public interface TransactionsRepository {
    List<Transaction> Get();
    Transaction Get(Accounts account);
    Boolean Post(Transaction transaction);
}
