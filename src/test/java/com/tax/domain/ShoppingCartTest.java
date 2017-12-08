package com.tax.domain;

import com.tax.common.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private ShoppingCartItem shoppingCartItem;
    private Product chocolates;
    private int quantity;
    private int itemPrice;
    private List<ShoppingCartItem> items;

    @Before
    public void runBeforeTestMethod() {
        chocolates = new Product("imported chocolates", 1000, "food", true);
        quantity = 2;
        itemPrice=2000;
        shoppingCartItem = new ShoppingCartItem(chocolates,quantity);
        items = List.list(shoppingCartItem);
        shoppingCart = new ShoppingCart(items);
    }

    //Verifies that the correct item is in the shopping cart
    @Test
    public void testGetItems() throws Exception {
        assertEquals(shoppingCart.getItems().toJavaList().get(0).getProduct().getProductName(), chocolates.getProductName());
    }

    @After
    public void runAfterTestMethod() {
        this.shoppingCartItem=null;
        this.chocolates=null;
        this.quantity=0;
        this.itemPrice=0;
    }
}
