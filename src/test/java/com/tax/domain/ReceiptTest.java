package com.tax.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class ReceiptTest {

    private ShoppingCartItem shoppingCartItem;
    private Product chocolates;
    private int quantity;
    private ReceiptLineItem receiptLineItem;
    private List<ReceiptLineItem> receiptLineItemList = new ArrayList<>();
    private Receipt receipt;

    @Before
    public void runBeforeTestMethod() {
        chocolates = new Product("imported chocolates", 1000, "food", true);
        quantity = 2;
        shoppingCartItem = new ShoppingCartItem(chocolates,quantity);
        receiptLineItem = new ReceiptLineItem(shoppingCartItem,5);
        receiptLineItemList.add(receiptLineItem);
        receipt = new Receipt(receiptLineItemList);
    }

    //Verifies correct total tax
    @Test
    public void testGetTotalTax() throws Exception {
        double totalTax = 1005.0;
        assertEquals(receipt.getTotalTax(),totalTax,totalTax);
    }

    //Verifies correct total cents value
    @Test
    public void testGetTotalCents() throws Exception {
        double totalCents = 11005.0;
        assertEquals(receipt.getTotalCents(),totalCents,totalCents);
    }

    @After
    public void runAfterTestMethod() {
        this.shoppingCartItem=null;
        this.chocolates=null;
        this.quantity=0;
        this.shoppingCartItem=null;
        this.receiptLineItem=null;
        this.receiptLineItemList=null;
        this.receipt=null;
    }
}
