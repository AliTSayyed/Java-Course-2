/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATS
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> product;
    private Map<String, Integer> stock;
    

    public Warehouse() {
        this.product = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.product.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (!this.product.containsKey(product)) {
            return -99;
        } else {
            return this.product.get(product);
        }
    }

    public int stock(String product) {
        if (!stock.containsKey(product)) {
            return 0;
        } else {
            return stock.get(product);
        }
    }

    public boolean take(String product) {
        if (!stock.containsKey(product)) {
            return false;
        }

        int newStock = 0;

        if (stock.get(product) > 0) {
            newStock = stock.get(product) - 1;
            stock.put(product, newStock);
            return true;
        }

        if (stock.get(product) == 0) {
            return false;
        }

        return true;
    }

    public Set<String> products() {
        Set<String> products = product.keySet();

        return products;
    }
}
