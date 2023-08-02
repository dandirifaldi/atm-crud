package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.controllers.BanksController;
import com.example.demo.entities.Atms;
import com.example.demo.entities.Banks;

public class AtmsRepositoryImpl implements AtmsRepository{
    private Connection connection;
    public AtmsRepositoryImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public List<Atms> Get() {
        List<Atms> atms = new ArrayList<>();
        String query = "Select * FROM tb_m_Atms";

        try {
            Banks bank = new Banks();
            BanksController bankcontroller = new BanksController();
            ResultSet resultset = connection.prepareStatement(query).executeQuery();
            while (resultset.next()) {
                Atms atm = new Atms( resultset.getInt(1), resultset.getString(2),bank,resultset.getLong(4));
                atm.setAtm_id(resultset.getInt(1));
                atm.setLocation(resultset.getString(2));
                atm.setBank(bankcontroller.Get(resultset.getString(3)));
                // bank.setBank_id(resultset.getString(3));
                atm.setAtmBalance(resultset.getLong(4));

                atms.add(atm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atms;
    }

    @Override
    public Atms Get(Integer atm_id) {
        String query = "Select * FROM tb_m_atms WHERE atm_id = ?";

        Atms atm= new Atms(atm_id);
        Banks bank = new Banks();
        // List<Banks> banks = new ArrayList<>();
        try {
            PreparedStatement preparestate = connection.prepareStatement(query);
            preparestate.setInt(1, atm_id);
            ResultSet resultset = preparestate.executeQuery();
            while (resultset.next()) {
                atm.setAtm_id(resultset.getInt(1));
                atm.setLocation(resultset.getString(2));
                atm.setBank(bank);
                bank.setBank_id(resultset.getString(3));
                atm.setAtmBalance(resultset.getLong(4));
            }
            return atm;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Boolean Post(Atms atm) {
        try {
            String sql = "INSERT INTO tb_m_Atms( location, bank_id, atmBalance) VALUES (?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, atm.getLocation());
            prepareStatement.setObject(2, atm.getBank());
            prepareStatement.setLong(3, atm.getAtmBalance());
            prepareStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean Put(Atms atm) {
        try {
            String sql = "Update tb_m_atms Set location = ?, bank_id=?, atmBalance=?  WHERE atm_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, atm.getLocation());
            prepareStatement.setObject(2, atm.getBank());
            prepareStatement.setLong(3, atm.getAtmBalance());
            prepareStatement.setInt(4, atm.getAtm_id());

            prepareStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }

    @Override
    public Boolean Delete(Integer atm_id) {
        try {
            String sql = "DELETE FROM tb_m_atms WHERE atm_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, atm_id);
            prepareStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
