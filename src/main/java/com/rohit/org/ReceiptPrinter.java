package com.rohit.org;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptPrinter {

    BigDecimal totalSalesTax=BigDecimal.ZERO;
    BigDecimal totalAmount=BigDecimal.ZERO;


    public void printReceipt(Basket basket){
       List<BasketItem> basketItems = basket.getBasketItems();

        for (var basketItem:basketItems){
            Product product=basketItem.getProduct();
            String isImported = imported(product);
            // considering quantity 1 for all
            BigDecimal totalPrice=   basketItem.getPrice().add(basketItem.getTaxPrice());
            System.out.println(basketItem.getQuantity()+" "+isImported+product.getName()+": "+ totalPrice);
            totalSalesTax=totalSalesTax.add(basketItem.getTaxPrice());
            totalAmount=totalAmount.add(totalPrice);
        }
        printSalesTaxAndTotalAmount(totalSalesTax,totalAmount);
    }

    private String imported(Product product) {
        String imported;
        if(product.isImported())
            imported = "imported ";
        else
            imported="";
        return imported;
    }

    private static void printSalesTaxAndTotalAmount(BigDecimal totalSalesTax, BigDecimal totalAmount) {
        System.out.println("Sales Taxes: "+totalSalesTax);
        System.out.println("Total: "+totalAmount);
    }
}
