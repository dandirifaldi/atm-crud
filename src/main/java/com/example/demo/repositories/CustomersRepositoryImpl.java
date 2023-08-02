package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Banks;
import com.example.demo.entities.Customers;

public class CustomersRepositoryImpl implements CustomersRepository{
    private Connection connection;
    public CustomersRepositoryImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Customers> Get() {
        List<Customers> customers = new ArrayList<>();
        String query = "Select A.account_id, C.fullName, C.phoneNumber, C.email, A.pin, A.balance, B.bank_id FROM tb_m_accounts A JOIN tb_m_customers C ON C.account_id=A.account_id JOIN tb_m_banks as B ON B.bank_id=A.bank_id";

        try {
            ResultSet resultset = connection.prepareStatement(query).executeQuery();
            Accounts account = new Accounts();
            Banks bank  = new Banks();
            while (resultset.next()) {
                Customers customer = new Customers( account, resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getLong(6), bank);
                
                customer.setAccount(account);
                account.setAccount_id(resultset.getString(1));
                customer.setFullName(resultset.getString(2));
                customer.setPhoneNumber(resultset.getString(3));
                customer.setEmail(resultset.getString(4));
                customer.setPin(resultset.getString(5));
                customer.setBalance(resultset.getLong(6));
                customer.setBank_id(bank);
                bank.setBank_id(resultset.getString(7));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customers Get(Accounts account) {
        String query = "Select A.account_id, C.fullName, C.phoneNumber, C.email, A.pin, A.balance,"+
        " B.bank_id FROM tb_m_accounts A JOIN tb_m_customers C "+
        "ON C.account_id=A.account_id JOIN tb_m_banks as B "+
        "ON B.bank_id=A.bank_id WHERE A.account_id = ?";

        Customers customer = new Customers();
        Banks bank = new Banks();
        // List<Banks> banks = new ArrayList<>();
        try {
            PreparedStatement preparestate = connection.prepareStatement(query);
            preparestate.setString(1, account.getAccount_id());
            ResultSet resultset = preparestate.executeQuery();
            while (resultset.next()) {
                customer.setAccount(account);
                account.setAccount_id(resultset.getString(1));
                customer.setFullName(resultset.getString(2));
                customer.setPhoneNumber(resultset.getString(3));
                customer.setEmail(resultset.getString(4));
                customer.setPin(resultset.getString(5));
                customer.setBalance(resultset.getLong(6));
                customer.setBank_id(bank);
                bank.setBank_id(resultset.getString(7));
            }
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Boolean Post(Customers customer) {
       try {
            String sql = "INSERT INTO tb_m_customers(account_id, fullName,phoneNumber, email) VALUES (?,?,?,?)";
            String sql2 = "INSERT INTO tb_m_accounts(account_id, pin, balance, bank_id) VALUES (?,?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            PreparedStatement prepareStatement2 = connection.prepareStatement(sql2);
            prepareStatement.setString(1, customer.getAccount().getAccount_id());
            prepareStatement.setString(2, customer.getFullName());
            prepareStatement.setString(3, customer.getPhoneNumber());
            prepareStatement.setString(4, customer.getEmail());
            prepareStatement2.setString(1, customer.getAccount().getAccount_id());
            prepareStatement2.setString(2, customer.getPin());
            prepareStatement2.setLong(3, customer.getBalance());
            prepareStatement2.setString(4, customer.getBank().getBank_id());
            prepareStatement2.execute();
            prepareStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean Put(Customers customer) {
        try {
            String sql = "Update tb_m_customers Set fullName = ?, phoneNumber = ?, email =?  WHERE account_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, customer.getFullName());
            prepareStatement.setString(2, customer.getPhoneNumber());
            prepareStatement.setString(3, customer.getEmail());
            prepareStatement.setString(4, customer.getAccount().getAccount_id());

            prepareStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Explicit Delete
    @Override
    public Boolean Delete(Accounts account) {
        try {
            String sql = "DELETE FROM tb_m_accounts WHERE account_id = ?";
            String sql2 = "DELETE FROM tb_m_customers WHERE account_id = ?";
            String sql3 = "DELETE FROM tb_tr_transactions WHERE account_id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            PreparedStatement prepareStatement2 = connection.prepareStatement(sql2);
            PreparedStatement prepareStatement3 = connection.prepareStatement(sql3);
            prepareStatement3.setString(1, account.getAccount_id());
            prepareStatement2.setString(1, account.getAccount_id());
            prepareStatement.setString(1, account.getAccount_id());
            prepareStatement3.executeUpdate();
            prepareStatement2.executeUpdate();
            prepareStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
