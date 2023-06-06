package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TaxPriceCalculatorSystemTest {
    @Test
    public void shouldBeAbleToCalculateOutputIfItemIsImportedAndExempted(){
        TaxPriceCalculatorSystem taxPriceCalculatorSystem = new TaxPriceCalculatorSystem();

        List<String> input= Arrays.asList(
                "1 imported box of chocolates at 10.00",
                "1 box of imported chocolates at 11.25"
                );

        String expectedOutput="""
                            1 imported box of chocolates: 10.50
                            1 imported box of chocolates: 11.85
                            Sales Taxes: 1.10
                            Total: 22.35
                            """;

        String actualOutput= taxPriceCalculatorSystem.getReceipt(input);

        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void shouldBeAbleToCalculateOutputIfItemIsImportedAndNotExempted(){
        TaxPriceCalculatorSystem taxPriceCalculatorSystem = new TaxPriceCalculatorSystem();

        List<String> input= Arrays.asList(
                "1 imported bottle of perfume at 27.99"
        );

        String expectedOutput="""
                            1 imported bottle of perfume: 32.19
                            Sales Taxes: 4.20
                            Total: 32.19
                            """;

        String actualOutput= taxPriceCalculatorSystem.getReceipt(input);

        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void shouldBeAbleToCalculateOutputIfItemIsNotImportedAndNotExempted(){
        TaxPriceCalculatorSystem taxPriceCalculatorSystem = new TaxPriceCalculatorSystem();

        List<String> input= Arrays.asList(
                "1 bottle of perfume at 18.99",
                "1 music CD at 14.99"
        );

        String expectedOutput="""
                            1 bottle of perfume: 20.89
                            1 music CD: 16.49
                            Sales Taxes: 3.40
                            Total: 37.38
                            """;

        String actualOutput= taxPriceCalculatorSystem.getReceipt(input);

        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void shouldBeAbleToCalculateOutputIfItemIsNotImportedAndExempted(){
        TaxPriceCalculatorSystem taxPriceCalculatorSystem = new TaxPriceCalculatorSystem();

        List<String> input= Arrays.asList(
                "1 book at 12.49",
                "1 chocolate bar at 0.85",
                "1 packet of headache pills at 9.75"
        );

        String expectedOutput="""
                            1 book: 12.49
                            1 chocolate bar: 0.85
                            1 packet of headache pills: 9.75
                            Sales Taxes: 0.00
                            Total: 23.09
                            """;

        String actualOutput= taxPriceCalculatorSystem.getReceipt(input);

        Assertions.assertEquals(expectedOutput,actualOutput);
    }
}