package com.rohit.org.application;

import com.rohit.org.input.ReceiptItemParser;
import com.rohit.org.model.Basket;
import com.rohit.org.model.BasketItem;
import com.rohit.org.model.Product;
import com.rohit.org.model.ReceiptItem;
import com.rohit.org.output.ReceiptPrinter;
import com.rohit.org.service.CategoryService;
import com.rohit.org.service.ProductService;
import com.rohit.org.service.TaxCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String line;
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
        String totalBilling = receiptPrinter.generateReceipt(basket);
        System.out.println(totalBilling);
    }
}
