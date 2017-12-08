package com.tax.domain;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptLineItemTest {

    private ShoppingCartItem shoppingCartItem;
    private Product chocolates;
    private int quantity;
    private int itemPrice;
    private ReceiptLineItem receiptLineItem;
    private Calculator  calculator;

    @Before
    public void runBeforeTestMethod() {
        chocolates = new Product("imported chocolates", 1000, "food", true);
        quantity = 2;
        itemPrice=2000;
        shoppingCartItem = new ShoppingCartItem(chocolates,quantity);
        receiptLineItem = new ReceiptLineItem(shoppingCartItem,5);
        calculator = receiptLineItem.getAmount();
    }

    //Verifies correct price and tax computation in cents.
    @Test
    public void testGetTotalItemPriceAndTax() throws Exception {
        //System.out.println(receiptLineItem.getTotalItemPriceAndTax());
        assertEquals(receiptLineItem.getTotalItemPriceAndTax(),1005);
    }

    //Verifies correct item invoice price.
    @Test
    public void testGetInvoiceItemPrice() throws Exception {
        //System.out.println(receiptLineItem.getInvoiceItemPrice());
        double price = 10.05;
        assertEquals(receiptLineItem.getInvoiceItemPrice(),price,price);
    }

    //Verifies correct tax amount computation
    @Test
    public void testGetAmount() throws Exception {

        assertEquals(calculator.getValue(),5);
    }

    //Verifies correct Total amount computation
    @Test
    public void testGetTotalAmount() throws Exception {
        Calculator calc = receiptLineItem.getCalculator();
        assertEquals(receiptLineItem.getTotalAmount().value,2000);
    }

    @After
    public void runAfterTestMethod() {
        this.shoppingCartItem=null;
        this.chocolates=null;
        this.quantity=0;
        this.itemPrice=0;
        this.shoppingCartItem=null;
        this.receiptLineItem=null;
        this.calculator=null;
    }
}
