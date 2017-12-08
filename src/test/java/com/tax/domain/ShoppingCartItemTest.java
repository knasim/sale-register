package com.tax.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartItemTest {

    private ShoppingCartItem shoppingCartItem;
    private Product chocolates;
    private int quantity;
    private int itemPrice;

    @Before
    public void runBeforeTestMethod() {
        chocolates = new Product("imported chocolates", 1000, "food", true);
        quantity = 2;
        itemPrice=2000;
        shoppingCartItem = new ShoppingCartItem(chocolates,quantity);
    }

    //Verifies correct item price calculation in cents
    @Test
    public void testComputePricePerQuantityInCents() throws Exception {
        assertEquals(shoppingCartItem.computeItemPricePerQuantity(),itemPrice);
    }

    @After
    public void runAfterTestMethod() {
        this.shoppingCartItem=null;
        this.chocolates=null;
        this.quantity=0;
        this.itemPrice=0;
    }
}
