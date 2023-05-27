package com.rohit.org;
import java.math.MathContext;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    private BigDecimal importTaxPercentage=BigDecimal.valueOf(5);
    private BigDecimal basicSalesTaxPercentage=BigDecimal.valueOf(10);

    public BigDecimal getTaxPerUnitProduct(Product product){
        BigDecimal unitPrice = product.getUnitPrice();
        BigDecimal importDuty = BigDecimal.ZERO;
        BigDecimal basicSalesDuty = BigDecimal.ZERO;

        boolean isImported = product.isImported();
        boolean isExempted = false;
        Category productCategory = product.getCategory();
        if (productCategory.equals(Category.BOOK) ||
                productCategory.equals(Category.FOOD) ||
                productCategory.equals(Category.MEDICAL)) {
            isExempted = true;
        }
        BigDecimal nonRoundOffTax= taxForBasketItem(isImported,isExempted,unitPrice);
        BigDecimal roundOffTax= calculateRoundOffValue(nonRoundOffTax);
        return roundOffTax;
    }

    private BigDecimal taxForBasketItem(boolean isImported, boolean isExempted, BigDecimal unitPrice) {
        BigDecimal importDuty = BigDecimal.ZERO;
        BigDecimal basicSalesDuty = BigDecimal.ZERO;
        if(isImported && isExempted) {
            importDuty = calculateTaxByTaxPercentage(unitPrice,importTaxPercentage);
        }
        else if(!isImported && !isExempted) {
            basicSalesDuty=calculateTaxByTaxPercentage(unitPrice,basicSalesTaxPercentage);
        }
        else if(!isImported && isExempted) {
            return BigDecimal.ZERO;
        }
        else if (isImported && !isExempted) {
            importDuty = calculateTaxByTaxPercentage(unitPrice,importTaxPercentage);
            basicSalesDuty=calculateTaxByTaxPercentage(unitPrice,basicSalesTaxPercentage);
        }
        return importDuty.add(basicSalesDuty);
    }

    private BigDecimal calculateRoundOffValue(BigDecimal number) {
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
