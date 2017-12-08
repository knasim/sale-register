package com.tax.register;

import com.sun.org.apache.regexp.internal.RE;
import com.tax.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SaleRegisterTest {
    private ShoppingCart shoppingCart;
    private SaleRegister saleRegister;
    private ShoppingCartItem shoppingCartItem;
    private Product chocolates;
    private int quantity;
    private ReceiptLineItem receiptLineItem;
    private List<ReceiptLineItem> receiptLineItemList = new ArrayList<>();
    private Receipt receipt;
    private List<String> taxExemptCategory=new ArrayList<>();
    private com.tax.common.List<ShoppingCartItem> items;

    @Before
    public void runBeforeTestMethod() {
        chocolates = new Product("imported chocolates", 1000, "food", true);
        quantity = 2;
        shoppingCartItem = new ShoppingCartItem(chocolates,quantity);
        receiptLineItem = new ReceiptLineItem(shoppingCartItem,5);
        receiptLineItemList.add(receiptLineItem);
        receipt = new Receipt(receiptLineItemList);
        taxExemptCategory.add("food");
        taxExemptCategory.add("books");
        taxExemptCategory.add("medical");
        saleRegister = new SaleRegister(taxExemptCategory);
        items = com.tax.common.List.list(shoppingCartItem);
        shoppingCart = new ShoppingCart(items);
    }

    //Verifies correct receipt line-item generation
    @Test
    public void testCalculateReceipt() throws Exception {
        receipt = saleRegister.calculateReceipt(shoppingCart);
        assertEquals(receipt.toString(),"- 2 imported chocolates: 11.0","- 2 imported chocolates: 11.0");
    }

    //Verifies tax reported on receipt
    @Test
    public void testTax() throws Exception {
        assertEquals(saleRegister.tax(shoppingCartItem),100.0,100.0);
    }

    //Verifies correct total reported on receipt
    @Test
    public void testTaxPercent() throws Exception {
       assertEquals(saleRegister.taxPercent(chocolates),5);
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
        taxExemptCategory=null;
    }
}
