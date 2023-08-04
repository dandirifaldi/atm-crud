package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Banks;

@Repository
public interface BanksRepository extends JpaRepository<Banks, String>{

}