package com.tax.domain;

public final class Product {

    private final String productName;
    private final int cents;
    private final String producteCategory;
    private final boolean isImported;

    public Product(String productName, int cents, String producteCategory, boolean isImported) {
        this.productName=productName;
        this.cents=cents;
        this.producteCategory=producteCategory;
        this.isImported=isImported;
    }

    public String getProductName() {
        return productName;
    }

    public int getCents() {
        return cents;
    }

    public String getProducteCategory() {
        return producteCategory;
    }

    public boolean isImported() {
        return isImported;
    }
}
