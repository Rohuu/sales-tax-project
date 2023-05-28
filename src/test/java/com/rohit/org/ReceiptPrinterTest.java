package com.rohit.org;

import com.rohit.org.model.Basket;
import com.rohit.org.model.BasketItem;
import com.rohit.org.model.Category;
import com.rohit.org.model.Product;
import com.rohit.org.output.ReceiptPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ReceiptPrinterTest {

    @Test
    public void shouldBeAbleToCreateReceiptPrinter(){
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Assertions.assertNotNull(receiptPrinter);
    }

    @Test
    public void shouldBeAbleToPrintReceipt(){
        ReceiptPrinter receiptPrinter=new ReceiptPrinter();
        Basket basket=new Basket();

        Product product=new Product("book", Category.BOOK,false, BigDecimal.valueOf(100));
        basket.addBasketItem(new BasketItem(product,1,BigDecimal.valueOf(100),BigDecimal.ZERO));
        String expected= """
                1 book: 100
                Sales Taxes: 0
                Total: 100
                """;
        String actual= receiptPrinter.generateReceipt(basket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCalculateTaxAndTotalAmount(){
        ReceiptPrinter receiptPrinter=new ReceiptPrinter();
        Basket basket=new Basket();
        Product product=new Product("book",Category.BOOK,false, BigDecimal.valueOf(100));
        basket.addBasketItem(new BasketItem(product,1,BigDecimal.valueOf(100),BigDecimal.ZERO));

        String expected= """
                Sales Taxes: 0
                Total: 100
                """;
        String actual= receiptPrinter.generateSalesTaxAndTotalAmount(BigDecimal.valueOf(0),BigDecimal.valueOf(100));

        Assertions.assertEquals(expected, actual);
    }
}
