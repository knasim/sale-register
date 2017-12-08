package com.tax.register;

import com.tax.domain.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SaleRegister {

    private static final int saleTax=10;
    private List<String> taxExemptCategory=new ArrayList<>();
    private static final int importTax=5;

    public  SaleRegister(List<String> taxExemptCategory) {
        this.taxExemptCategory=taxExemptCategory;
    }

    public Receipt calculateReceipt(ShoppingCart cart) {
        List<ReceiptLineItem> rliLIst = new ArrayList<>();
        cart.getItems().forEach(value -> {
            ShoppingCartItem sct = value;
            double tax = tax(sct);
            int taxInt = (int) Math.ceil(tax);
            ReceiptLineItem lineItem = new ReceiptLineItem(sct, taxInt);
            rliLIst.add(lineItem);
        });
        Receipt receipt = new Receipt(rliLIst);
        return receipt;
    }

    public double tax(ShoppingCartItem cartItem) {
        DecimalFormat format = new DecimalFormat("#.##");
        int taxPercentage = taxPercent(cartItem.getProduct());
        int itemPricePerQuanity = cartItem.computeItemPricePerQuantity();
        double priceQuantityPercentage = itemPricePerQuanity * taxPercentage;
        double tax = priceQuantityPercentage/100;
        return 5 * ( tax / 5 );
    }

    public int taxPercent(Product product) {
        int computedImportTax = importTax;
        int computedSalesTax = saleTax;
        if(!product.isImported())
            computedImportTax=0;
         if(taxExemptCategory.contains(product.getProducteCategory()))
             computedSalesTax=0;
         return computedSalesTax + computedImportTax;
    }

    /*public static void main(String ... args) {
        Product chocolates = new Product("imported box of chocolates", 1000, "food", true);
        Product perfume = new Product("imported bottle of perfume", 4750, "perfume",true);

        ShoppingCartItem item1 = new ShoppingCartItem(chocolates,1);
        ShoppingCartItem item2 = new ShoppingCartItem(perfume,1);

        com.tax.common.List list = com.tax.common.List.list(item1,item2);

        ShoppingCart cart = new ShoppingCart(list);

        List<String> taxExemptCategory=new ArrayList<>();
        taxExemptCategory.add("food");
        taxExemptCategory.add("books");
        taxExemptCategory.add("medical");

        SaleRegister register = new SaleRegister(taxExemptCategory);

        Receipt receipt = register.calculateReceipt(cart);
        System.out.println(receipt.toString());
        System.out.println("Sales Taxes: " + receipt.getTotalTax() + "\n\nTotal: " + receipt.getTotalCents());
    }*/
}