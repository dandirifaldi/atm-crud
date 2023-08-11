package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Accounts;
import com.example.demo.entities.Banks;
import com.example.demo.entities.Cards;
import com.example.demo.entities.Customers;
import com.example.demo.repositories.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService{

    @Autowired
    private AccountsRepository accountRepo;
    @Autowired
    private BanksService banksService;
    @Autowired
    private CustomersService customersService;
    @Autowired
    private CardsService cardsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<Accounts> Get() {
        return accountRepo.findAll();
    }

    @Override
    public Accounts Get(String id) {
        return accountRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Accounts model) {
        accountRepo.save(model);
        return accountRepo.findById(model.getAccount_id()).isPresent();
    }

    @Override
    public Boolean Delete(String id) {
        accountRepo.deleteById(id);
        return !accountRepo.findById(id).isPresent();    
    }

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        Accounts account = new Accounts();
        account.setAccount_id(registerRequest.getAccount_id());
        account.setBalance(registerRequest.getBalance());
        account.setPin(passwordEncoder.encode(registerRequest.getPin()));
        Banks banks = banksService.Get(registerRequest.getBank_id());
        Cards cards = cardsService.Get(registerRequest.getCard_id());
        account.setBank_id(banks);
        account.setCard(cards);
        // Save(account);
        Customers customer = new Customers();
        customer.setAccount(account);
        customer.setFullname(registerRequest.getFullName());
        customer.setEmail(registerRequest.getEmail());
        customer.setPhonenumber(registerRequest.getPhoneNumber());
        Boolean result = customersService.Save(customer);
        return result;
    }
    
}
