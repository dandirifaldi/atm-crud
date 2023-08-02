package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Accounts;
import com.example.demo.entities.Atms;
import com.example.demo.entities.Transaction;

public class TransactionsRepositoryImpl implements TransactionsRepository{

    private Connection connection;
    public TransactionsRepositoryImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public List<Transaction> Get() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT a.account_id, t.transactionType, t.transferedTo, t.amount, atm.atm_id "+
        "FROM tb_tr_transactions t JOIN tb_m_accounts a ON a.account_id = t.account_id "+
        "JOIN tb_m_atms atm ON atm.atm_id=t.atm_id";

        try {
            ResultSet resultset = connection.prepareStatement(query).executeQuery();
            Accounts account = new Accounts();
            Atms atm  = new Atms();
            while (resultset.next()) {
                Transaction transaction = new Transaction();
                
                transaction.setAccount(account);
                account.setAccount_id(resultset.getString(1));
                transaction.setTransactionType(resultset.getString(2));
                transaction.setTransferedTo(resultset.getString(3));
                transaction.setAmount(resultset.getLong(4));
                transaction.setAtm(atm);
                atm.setAtm_id(resultset.getInt(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public Transaction Get(Accounts account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Get'");
    }

    @Override
    public Boolean Post(Transaction transaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Post'");
    }
    
}
