/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void add(String product, int price) {
        for (Item item : items) {
            if (item.toString().startsWith(product + ":")) {
                // If found, increase the quantity and return
                item.increaseQuantity();
                return;
            }
        }

        Item newItem = new Item(product, 1, price);
        items.add(newItem);
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

}
