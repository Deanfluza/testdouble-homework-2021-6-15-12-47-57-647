package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountTest {

    @Test
    void should_transaction_repo_add_deposit_been_call_when_execute_deposit() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 100;

        //when
        account.deposit(amount);

        //then
        verify(transactionRepository, times(1)).addDeposit(amount);
    }

    @Test
    void should_transaction_repo_add_withdraw_been_call_when_execute_withdraw() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 100;

        //when
        account.withdraw(amount);

        //then
        verify(transactionRepository, times(1)).addWithdraw(amount);
    }

    @Test
    void should_print_and_trans_repo_allTransactions_been_call_when_execute_printStatement() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);

        //when
        account.printStatement();

        //then
        verify(transactionRepository, times(1)).allTransactions();
        verify(printer, times(1)).print(anyList());
    }
}