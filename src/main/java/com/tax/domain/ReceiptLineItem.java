package com.tax.domain;


import java.text.DecimalFormat;

public class ReceiptLineItem {

     private ShoppingCartItem item;
     private int tax;  // in cents
     private Calculator calculator;

     public ReceiptLineItem(ShoppingCartItem item, int tax) {
         this.item=item;
         this.tax=tax;
     }

     public int getItemSalePrice() {
         return item.getProduct().getCents();
     }

    public int getTax() {
        return tax;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    int getItemQuantity() {
         return item.getQuantity();

     }

     public String getItemName() {
         return item.getProduct().getProductName();
     }

     public int getTotalItemPriceAndTax() {
         return getItemSalePrice() + tax;
     }

     public double getInvoiceItemPrice() {
         return getTotalItemPriceAndTax() / 100.0;
     }

     public double getProductRetailPrice() {
         return item.getProduct().getCents();
     }

     public Calculator getAmount() {
         calculator = new Calculator(tax);
         return calculator;

     }

     public Calculator getTotalAmount() {
        calculator = new Calculator(item.computeItemPricePerQuantity());
        return calculator;
     }
     public String toString() {
         return getItemQuantity()  + " " + getItemName() + " " + getInvoiceItemPrice();
     }

}
