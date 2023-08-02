package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Banks;

public class BanksRepositoryImpl implements BanksRepository{
    private Connection connection;

    public BanksRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Banks> getAll() {
        List<Banks> banks = new ArrayList<>();
        String query = "Select * FROM tb_m_banks";

        try {
            ResultSet resultset = connection.prepareStatement(query).executeQuery();
            while (resultset.next()) {
                Banks bank = new Banks( resultset.getString(1), resultset.getString(2));
                
                bank.setBank_id(resultset.getString(1));
                bank.setName(resultset.getString(2));
                banks.add(bank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return banks;
    }

    @Override
    public Banks Get(String bank_id) {
        String query = "Select * FROM tb_m_banks WHERE bank_id = ?";

        Banks bank = new Banks();
        // List<Banks> banks = new ArrayList<>();
        try {
            PreparedStatement preparestate = connection.prepareStatement(query);
            preparestate.setString(1, bank_id);
            ResultSet resultset = preparestate.executeQuery();
            while (resultset.next()) {
                bank.setBank_id(resultset.getString(1));
                bank.setName(resultset.getString(2));
                // banks.add(bank);
            }
            return bank;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Boolean Post(Banks bank) {
        try {
            String sql = "INSERT INTO tb_m_banks(bank_id, name) VALUES (?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, bank.getBank_id());
            prepareStatement.setString(2, bank.getName());
            prepareStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean Put(Banks bank) {
        try {
            String sql = "Update tb_m_banks Set name = ?  WHERE bank_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, bank.getName());
            prepareStatement.setString(2, bank.getBank_id());

            prepareStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }

    @Override
    public Boolean Delete(String bank_id) {
        try {
            String sql = "DELETE FROM tb_m_banks WHERE bank_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, bank_id);
            prepareStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
