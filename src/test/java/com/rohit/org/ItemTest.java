package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ItemTest {

    @Test
    public void shouldBeAbleToCreateAnItem(){
        Item item = new Item();

        Assertions.assertNotNull(item);
    }
}