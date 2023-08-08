package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, String>{
}
