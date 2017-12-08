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
}
