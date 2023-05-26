package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {

    @Test
    public void shouldBeAbleToCreateTaxCalculator(){
        TaxCalculator taxCalculator = new TaxCalculator();

        Assertions.assertNotNull(taxCalculator);
    }
}
