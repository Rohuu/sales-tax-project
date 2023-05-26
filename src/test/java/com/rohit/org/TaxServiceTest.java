package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaxServiceTest {

    @Test
    public void shouldBeAbleToCreateTaxService(){
        TaxService taxService = new TaxService();

        Assertions.assertNotNull(taxService);
    }
}
