package com.jg.restApi.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("Should calculate discount")
    void getDiscount() {
        //given
        Product product = new Product();
        Discount discount = new Discount();
        product.setPrice(100f);
        product.setType("F");
        discount.setDiscount(0.05f);

        float expected = 95f;
        // when
        product.getDiscount(discount.getDiscount());
        float result = product.getPrice();
        // then
        Assertions.assertEquals(expected, result);
    }
}