package com.rohit.org;

import com.rohit.org.service.TaxCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {

    @Test
    public void shouldBeAbleToCreateTaxCalculator(){
        TaxCalculator taxCalculator = new TaxCalculator();

        Assertions.assertNotNull(taxCalculator);
    }
}
