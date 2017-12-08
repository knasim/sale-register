package com.tax.domain;

import static com.tax.common.CollectionUtilities.list;
import static com.tax.common.CollectionUtilities.foldLeft;

import java.text.DecimalFormat;
import java.util.List;

public class Receipt {

    private List<ReceiptLineItem> items;

    public Receipt(List<ReceiptLineItem> items) {
        this.items=items;
    }

    public double getTotalTax() {
        List<ReceiptLineItem> order = list(this.items);
        Calculator calc = foldLeft(order,Calculator.ZERO,Calculator.sum);
        double result = calc.getValue()/100.0;
        return result;
    }

    public double getTotalCents() {
        List<ReceiptLineItem> order = list(this.items);
        Calculator calculatedTax = foldLeft(order,Calculator.ZERO,Calculator.sum);
        Calculator calculatedTotal= foldLeft(order,Calculator.ZERO,Calculator.totalSum);
        double total = ((calculatedTotal.getValue() + calculatedTax.getValue()) / 100.0);
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat format = new DecimalFormat("#.##");
        items.forEach(item-> {
            ReceiptLineItem receiptLineItem = item;
            sb.append("- " + receiptLineItem.getItemQuantity() + " "  + receiptLineItem.getItemName()+ ": " + format.format(receiptLineItem.getInvoiceItemPrice()) + "\n");
        });
        return String.format(sb.toString());
    }
}