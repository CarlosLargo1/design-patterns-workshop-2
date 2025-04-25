package com.example.patterns_banking.services.commands;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllAccountsCommand implements ICommand<List<Account>> {
    private final IAccountRepository accountRepository;

    @Autowired
    public AllAccountsCommand(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<Account> execute() {
        return accountRepository.findAll();
    }
}
