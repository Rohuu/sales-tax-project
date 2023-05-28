package com.rohit.org;

import com.rohit.org.input.ReceiptItemParser;
import com.rohit.org.model.ReceiptItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptItemParserTest {

    @Test
    public void shouldBeAbleToCreateReceiptItemParser(){
        ReceiptItemParser receiptItemParser=new ReceiptItemParser();

        Assertions.assertNotNull(receiptItemParser);
    }

    @Test
    public void shouldBeAbleToParseInputToCreateReceiptItem(){
        ReceiptItemParser receiptItemParser=new ReceiptItemParser();
        ReceiptItem receiptItem = receiptItemParser.parseInput("1 imported box of chocolates at 10.00");

        Assertions.assertEquals(1,receiptItem.getQuantity());
        Assertions.assertTrue(receiptItem.isImported());
        Assertions.assertEquals("box of chocolates",receiptItem.getProductName());
        Assertions.assertEquals("10.00",receiptItem.getUnitPrice().toString());
    }
}
