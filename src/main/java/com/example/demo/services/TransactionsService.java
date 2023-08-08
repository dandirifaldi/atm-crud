package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Transactions;

public interface TransactionsService {
    List<Transactions> Get();
    Transactions Get(Integer id);
    Boolean Save(Transactions trnansaction);
}
