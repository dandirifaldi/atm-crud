package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cards;
@Repository
public interface CardsRepository extends JpaRepository<Cards,String>{
    
}
