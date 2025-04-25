package com.example.patterns_banking.factory;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LowAccountFactoryProvider {
    private final CheckingAccountFactory checkingAccountFactory;
    private final SavingsAccountFactory savingsAccountFactory;
    private final BasicAccountFactory basicAccountFactory;

    public LowAccountFactoryProvider(CheckingAccountFactory checkingAccountFactory,
                                     SavingsAccountFactory savingsAccountFactory,
                                     BasicAccountFactory basicAccountFactory) {
        this.checkingAccountFactory = checkingAccountFactory;
        this.savingsAccountFactory = savingsAccountFactory;
        this.basicAccountFactory = basicAccountFactory;
    }

    public AccountFactory getFactory(AccountType type) {
        Map<AccountType, AccountFactory> factories = Map.of(
                AccountType.CHECKING, checkingAccountFactory,
                AccountType.SAVINGS, savingsAccountFactory,
                AccountType.LOW_AMOUNT, basicAccountFactory);

        return  factories.get(type);
    }

    public enum AccountType {CHECKING, SAVINGS, LOW_AMOUNT}
}