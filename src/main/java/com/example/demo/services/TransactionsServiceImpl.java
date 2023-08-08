package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transactions;
import com.example.demo.repositories.TransactionsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    private TransactionsRepository transactionRepo;

    @Override
    public List<Transactions> Get() {
        return transactionRepo.findAll();
    }

    @Override
    public Transactions Get(Integer id) {
        return transactionRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Transactions transaction) {
        transactionRepo.save(transaction);
        return transactionRepo.findById(transaction.getTransaction_id()).isPresent();
    }
}
