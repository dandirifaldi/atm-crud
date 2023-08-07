package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    private TransactionsRepository transactionRepo;

    @Override
    public List<Transaction> Get() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction Get(Accounts id) {
        return transactionRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Transaction transaction) {
        transactionRepo.save(transaction);
        return transactionRepo.findById(transaction.getAccount()).isPresent();
    }
}
