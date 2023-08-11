package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, String>{
    @Query(value = "select a from Accounts a where a.account_id = ?1")
    public Accounts login(String Account_id);
}
