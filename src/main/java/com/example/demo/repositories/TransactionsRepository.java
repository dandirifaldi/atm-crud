package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Transaction;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction,Accounts>{
    
}
