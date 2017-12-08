package com.tax;

import com.tax.domain.Product;
import com.tax.domain.Receipt;
import com.tax.domain.ShoppingCart;
import com.tax.domain.ShoppingCartItem;
import com.tax.register.SaleRegister;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *  Main Program for Sale Register
 *  Author: Khurrum Nasim
 *  Since:  Dec 7 2017
 */

public class Main {
    public static void main(String ... args) {
        SaleRegister register;
        List<String> taxExemptCategory=new ArrayList<>();
        taxExemptCategory.add("food");
        taxExemptCategory.add("books");
        taxExemptCategory.add("medical");
        register = new SaleRegister(taxExemptCategory);


        //input 1
        Product book = new Product("book", 1249, "books", false);
        Product musicCD = new Product("music CD", 1499, "music",false);
        Product chocolateBar = new Product("chocolate bar", 85, "food",false);

        ShoppingCartItem bookItem = new ShoppingCartItem(book,1);
        ShoppingCartItem musicCDItem = new ShoppingCartItem(musicCD,1);
        ShoppingCartItem chocolateBarItem = new ShoppingCartItem(chocolateBar,1);

        com.tax.common.List shoppingOrderInputMusicBooks = com.tax.common.List.list(bookItem,musicCDItem,chocolateBarItem);

        ShoppingCart cartOrderMusicBooks = new ShoppingCart(shoppingOrderInputMusicBooks);

        Receipt receiptOrderMusicBooks = register.calculateReceipt(cartOrderMusicBooks);
        System.out.println("\n### Output 1");
        System.out.println(receiptOrderMusicBooks.toString());
        System.out.println("Sales Taxes: " + receiptOrderMusicBooks.getTotalTax() + "\n\nTotal: " + receiptOrderMusicBooks.getTotalCents());


        //Input 2
        Product chocolates = new Product("imported box of chocolates", 1000, "food", true);
        Product perfume = new Product("imported bottle of perfume", 4750, "perfume",true);

        ShoppingCartItem chocolatesItem = new ShoppingCartItem(chocolates,1);
        ShoppingCartItem perfumeItem = new ShoppingCartItem(perfume,1);

        com.tax.common.List shoppingOrderPerfumeAndChocolate = com.tax.common.List.list(chocolatesItem,perfumeItem);

        ShoppingCart cartOrderPerfumeChocolate = new ShoppingCart(shoppingOrderPerfumeAndChocolate);

        Receipt receiptOrderPerfumeChocolate = register.calculateReceipt(cartOrderPerfumeChocolate);
        System.out.println("\n### Output 2");
        System.out.println(receiptOrderPerfumeChocolate.toString());
        System.out.println("Sales Taxes: " + receiptOrderPerfumeChocolate.getTotalTax() + "\n\nTotal: "
                + receiptOrderPerfumeChocolate.getTotalCents());


        //input 3
        Product perfumeImported = new Product("imported bottle of perfume", 2799, "perfume", true);
        Product perfumeRegular = new Product("bottle of perfume", 1899, "perfume",false);
        Product pills = new Product("packet of headache pills", 975, "medical",false);
        Product importedChocolates = new Product("box of imported box of chocolates", 1125, "food", true);

        ShoppingCartItem perfumeImportedItem = new ShoppingCartItem(perfumeImported,1);
        ShoppingCartItem perfumeRegularItem = new ShoppingCartItem(perfumeRegular,1);
        ShoppingCartItem pillsItem = new ShoppingCartItem(pills,1);
        ShoppingCartItem importedChocolatesItem = new ShoppingCartItem(importedChocolates,1);

        com.tax.common.List shoppingPerfumePillChocolate =
                com.tax.common.List.list(perfumeImportedItem,perfumeRegularItem,pillsItem,importedChocolatesItem);

        ShoppingCart shoppingCartPerfumePillChocoloate = new ShoppingCart(shoppingPerfumePillChocolate);

        Receipt receiptOrderPerfumePillChocolate = register.calculateReceipt(shoppingCartPerfumePillChocoloate);
        System.out.println("\n### Output 3");
        System.out.println(receiptOrderPerfumePillChocolate.toString());
        System.out.println("Sales Taxes: " + receiptOrderPerfumePillChocolate.getTotalTax() +
                "\n\nTotal: " + receiptOrderPerfumePillChocolate.getTotalCents());
    }
}
