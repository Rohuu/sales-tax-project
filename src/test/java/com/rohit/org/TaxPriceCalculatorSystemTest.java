package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxPriceCalculatorSystemTest {
    @Test
    public void shouldBeAbleToCalculateOutputFromGivenInput(){
        TaxPriceCalculatorSystem taxPriceCalculatorSystem = new TaxPriceCalculatorSystem();

        List<String> inputItems= Arrays.asList(
                "1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25"
        );
        String expected= """
                        1 imported bottle of perfume: 32.19
                        1 bottle of perfume: 20.89
                        1 packet of headache pills: 9.75
                        1 imported box of chocolates: 11.85
                        Sales Taxes: 6.70
                        Total: 74.68
                        """;
        String actual= taxPriceCalculatorSystem.getReceipt(inputItems);

        Assertions.assertEquals(expected,actual);
    }

}