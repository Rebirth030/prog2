package de.hhn.prog2.lab03;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> cart = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        int count = cart.getOrDefault(product, 0);
        cart.put(product, count + 1);
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void removeProduct(Product product, int quantity) {
        if(cart.containsKey(product)) {
            int count = cart.get(product);
            if(quantity >= count) {
                cart.remove(product);
            } else {
                cart.put(product, count - quantity);
            }
        } else {
            throw new IllegalStateException("Product not found.");
        }
    }

    public void removeProduct(Product product) {
        removeProduct(product, 1);
    }

    public void removeAll() {
        cart.clear();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public boolean containsProduct(Product product) {
        return cart.containsKey(product);
    }

    public double totalPrice() {
        double ret = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            ret += product.getPrice();
        }
        return ret;
    }

    public int getQuantity(Product product) {
        return cart.get(product);
    }

    public String toString() {
        return cart.toString();
    }

}
