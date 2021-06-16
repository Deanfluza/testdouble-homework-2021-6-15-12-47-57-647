package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    void should_system_print_the_same_value_when_execute_printLine() throws IOException {
        //given
        Console console = new Console();
        String printValue = "system test";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        //when
        console.printLine(printValue);
        byteArrayOutputStream.flush();

        //then
        String allWrittenLines = new String(byteArrayOutputStream.toByteArray());
        assertTrue(allWrittenLines.contains("system test"));
    }
}