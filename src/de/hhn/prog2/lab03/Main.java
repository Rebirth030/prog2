package de.hhn.prog2.lab03;

public class Main {
    public static void main(String[] args) {
        // Sample Usage
        Product banana = new Product("Banana", 50);
        Product apple = new Product("Apple", 100);
        Product pineapple = new Product("Pineapple", 200);

        // Create new shopping cart
        ShoppingCart cart = new ShoppingCart();

        cart.isEmpty(); // returns true

        cart.addProduct(banana);
        cart.addProduct(apple, 3);

        cart.getQuantity(banana); // returns 1
        cart.getQuantity(apple); // returns 3

        cart.isEmpty(); // returns false

        cart.containsProduct(banana); // returns true
        cart.containsProduct(pineapple); // returns false

        cart.addProduct(pineapple, 2);

        cart.totalPrice();
        
        cart.removeProduct(banana);

        System.out.println(cart); // prints shopping cart content

        cart.removeAll();
    }
}
