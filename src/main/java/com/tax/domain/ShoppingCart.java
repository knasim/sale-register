package com.tax.domain;

import com.tax.common.List;

public class ShoppingCart {

    private List<ShoppingCartItem> items = List.list();
    public ShoppingCart(List<ShoppingCartItem> items) {
        this.items=items;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

}