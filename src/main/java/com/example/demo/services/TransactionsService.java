package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Transaction;

public interface TransactionsService {
    List<Transaction> Get();
    Transaction Get(Accounts account);
    Boolean Save(Transaction trnansaction);
}
