package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptPrinterTest {

    @Test
    public void shouldBeAbleToCreateReceiptPrinter(){
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Assertions.assertNotNull(receiptPrinter);
    }
}
