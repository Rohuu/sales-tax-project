package com.rohit.org;

import java.util.Scanner;

public class PrintReceipt {

    public static void main(String[] args) {
        Basket basket=new Basket();
        CategoryService categoryService=new CategoryService();
        ProductService productService=new ProductService(categoryService);
        ReceiptItemParser receiptItemParser=new ReceiptItemParser();


        //Input
        System.out.println("Enter your input: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ReceiptItem receiptItem = receiptItemParser.parseInput(line);
            Product product=productService.createProduct(receiptItem.getProductName(),receiptItem.isImported(),receiptItem.getUnitPrice());
        }
    }
}
