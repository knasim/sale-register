package com.tax.domain;

public class ShoppingCartItem {

   private Product product;
   private int quantity;

   public ShoppingCartItem(Product product, int quantity) {
       this.product=product;
       this.quantity=quantity;
   }

   public int computeItemPricePerQuantity() {
        return product.getCents() * quantity;
   }

   public String getItemName() {
       return product.getProductName();
   }

   public Product getProduct() {
        return product;
    }

   public int getQuantity() {
        return quantity;
    }
}