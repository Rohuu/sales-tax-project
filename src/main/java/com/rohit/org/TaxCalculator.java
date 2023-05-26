package com.rohit.org;
import java.math.MathContext;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    private BigDecimal importTaxPercentage=BigDecimal.valueOf(5);
    private BigDecimal basicSalesTaxPercentage=BigDecimal.valueOf(10);


    public BigDecimal calculateAllTaxes(Product product,ReceiptItem receiptItem){
        BigDecimal unitPrice=product.getUnitPrice();
        int quantity=receiptItem.getQuantity();

        BigDecimal importDuty=BigDecimal.ZERO;
        BigDecimal basicSalesDuty=BigDecimal.ZERO;
        BigDecimal priceIncludingTaxes = BigDecimal.ZERO;

        boolean isImported=product.isImported();
        boolean isExempted=false;
        Category productCategory=product.getCategory();
        if(productCategory.equals(Category.BOOK) ||
                productCategory.equals(Category.FOOD) ||
                    productCategory.equals(Category.MEDICAL)){
            isExempted=true;
        }

        if(isImported && isExempted) {
            importDuty = calculateTaxByTaxPercentage(unitPrice,importTaxPercentage);
            BigDecimal roundOfTotalTax = calculateRoundValue(importDuty);
            priceIncludingTaxes=unitPrice.add(roundOfTotalTax);
        }
        else if(!isImported && !isExempted) {
            basicSalesDuty=calculateTaxByTaxPercentage(unitPrice,basicSalesTaxPercentage);
            BigDecimal roundOfTotalTax = calculateRoundValue(basicSalesDuty);
            priceIncludingTaxes=unitPrice.add(roundOfTotalTax);
        }
        else if(!isImported && isExempted) {
            priceIncludingTaxes = unitPrice;
        }
        else if (isImported && !isExempted) {
            importDuty = calculateTaxByTaxPercentage(unitPrice,importTaxPercentage);
            basicSalesDuty=calculateTaxByTaxPercentage(unitPrice,basicSalesTaxPercentage);
            BigDecimal roundOfTotalTax= calculateRoundValue(importDuty.add(basicSalesDuty));
            priceIncludingTaxes=unitPrice.add(roundOfTotalTax);
        }
        return priceIncludingTaxes;
    }
    private BigDecimal calculateRoundValue(BigDecimal number) {
        BigDecimal decimalNumber = number;
        BigDecimal roundedNumber = decimalNumber.setScale(1, RoundingMode.HALF_UP);
        BigDecimal remainder = roundedNumber.remainder(new BigDecimal("0.05"));

        if (remainder.compareTo(new BigDecimal("0.025")) >= 0) {
            roundedNumber = roundedNumber.add(new BigDecimal("0.05").subtract(remainder));
        } else {
            roundedNumber = roundedNumber.subtract(remainder);
        }

        return roundedNumber;
    }

    private BigDecimal calculateTaxByTaxPercentage(BigDecimal unitPrice, BigDecimal taxPercentage){
        BigDecimal calculatedTax = (taxPercentage.multiply(unitPrice)).divide(BigDecimal.valueOf(100));
        return calculatedTax;
    }
}
