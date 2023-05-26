package com.rohit.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class SalesTaxApplication {

    public static void main(String[] args) throws IOException {
        Basket basket = new Basket();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService(categoryService);
        ReceiptItemParser receiptItemParser = new ReceiptItemParser();
        TaxCalculator taxCalculator = new TaxCalculator();


        //Input
        System.out.println("Enter your input: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null && line.length() > 0) {
            ReceiptItem receiptItem = receiptItemParser.parseInput(line);
            Product product = productService.createProduct(
                    receiptItem.getProductName(),
                    receiptItem.isImported(),
                    receiptItem.getUnitPrice()
            );
            BasketItem basketItem = new BasketItem(
                    product,
                    receiptItem.getQuantity(),
                    receiptItem.getUnitPrice(),
                    taxCalculator.getTaxPerUnitProduct(product)
            );
            basket.addBasketItem(basketItem);
        }
        ReceiptPrinter receiptPrinter=new ReceiptPrinter();
        receiptPrinter.printReceipt(basket);
    }
}
