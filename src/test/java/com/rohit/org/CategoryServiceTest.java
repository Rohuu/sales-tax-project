package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryServiceTest {

    @Test
    public void shouldBeAbleToCreateCategoryService(){
        CategoryService categoryService = new CategoryService();

        Assertions.assertNotNull(categoryService);
    }

    @Test
    public void shouldBeAbleToReturnCategoryByProductName(){
        CategoryService categoryService = new CategoryService();
        Category category= categoryService.getCategoryByProductName("book");

        Assertions.assertEquals(Category.BOOK,category);
    }



}
