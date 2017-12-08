package com.tax.domain;
import com.tax.common.Function;

public class Calculator {

    public static Calculator ZERO = new Calculator(0);
    public static Function<Calculator, Function<ReceiptLineItem, Calculator>> sum = x -> y -> x.add(y.getAmount());
    public static Function<Calculator, Function<ReceiptLineItem, Calculator>> totalSum = x -> y -> x.add(y.getTotalAmount());

    public final int value;

    public Calculator(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public Calculator add(Calculator that) {
        return new Calculator(this.value + that.getValue());
    }

    public Calculator total(Calculator that) {
        return new Calculator(this.value + that.getValue());
    }
}
