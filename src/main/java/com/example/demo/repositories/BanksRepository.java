package com.example.demo.repositories;
import java.util.List;
import com.example.demo.entities.Banks;

public interface BanksRepository {
    List<Banks> getAll();
    Banks Get(String bank_id);
    Boolean Post(Banks bank);
    Boolean Put(Banks bank);
    Boolean Delete(String bank_id);
}