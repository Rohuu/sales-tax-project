package com.rohit.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class PrintReceipt {

    public static void main(String[] args) throws IOException {
        Basket basket=new Basket();
        CategoryService categoryService=new CategoryService();
        ProductService productService=new ProductService(categoryService);
        ReceiptItemParser receiptItemParser=new ReceiptItemParser();
        TaxCalculator taxCalculator = new TaxCalculator();
        BigDecimal totalSalesTax=BigDecimal.ZERO;
        BigDecimal totalAmount=BigDecimal.ZERO;


        //Input
        System.out.println("Enter your input: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while ((line=br.readLine())!=null && line.length()>0){
            ReceiptItem receiptItem = receiptItemParser.parseInput(line);
            Product product=productService.createProduct(receiptItem.getProductName(),receiptItem.isImported(),receiptItem.getUnitPrice());
            BigDecimal totalProductPrice=taxCalculator.calculateAllTaxes(product,receiptItem);
            BigDecimal tax=totalProductPrice.subtract(product.getUnitPrice());
            printReceiptData(receiptItem, totalProductPrice,receiptItemParser);
            totalSalesTax=totalSalesTax.add(tax);
            totalAmount=totalAmount.add(totalProductPrice);
        }
        printSalesTaxAndTotalAmount(totalSalesTax,totalAmount);
    }

    private static void printSalesTaxAndTotalAmount(BigDecimal totalSalesTax,BigDecimal totalAmount) {
        System.out.println("Sales Taxes: "+totalSalesTax);
        System.out.println("Total: "+totalAmount);
    }

    private static void printReceiptData(ReceiptItem receiptItem, BigDecimal totalPrice,ReceiptItemParser receiptItemParser) {
        if(receiptItem.isImported())
            System.out.println(receiptItem.getQuantity()+ " imported "+receiptItem.getProductName() + ": "+totalPrice);
        else
            System.out.println(receiptItem.getQuantity()+ " "+receiptItem.getProductName() + ": "+totalPrice);

    }
}
