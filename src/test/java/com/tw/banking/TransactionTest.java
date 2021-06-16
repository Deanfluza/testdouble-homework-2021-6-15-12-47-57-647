package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;

class TransactionTest {

    @Test
    void should_return_1_when_compare_transaction_date_is_after_my_transaction() {
        //given
        int amount = anyInt();
        String now = "16/06/2021";
        String past = "15/06/2021";
        Transaction transactionForNow = new Transaction(now, amount);
        Transaction transactionForPast = new Transaction(past, amount);

        //when
        int result = transactionForNow.compareTo(transactionForPast);

        //then
        assertEquals(1, result);
    }
}