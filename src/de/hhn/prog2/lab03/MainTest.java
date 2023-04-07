package de.hhn.prog2.lab03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasse für die JUnit-Tests
 */
class MainTest {
    static ShoppingCart cart;
    static Product banana;
    static Product apple;
    static Product pineapple;

    @BeforeAll
    static void beforeAll() {
        banana = new Product("Banana", 50);
        apple = new Product("Apple", 100);
        pineapple = new Product("Pineapple", 200);
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void test1() {
        cart.addProduct(apple, 5);
        assertEquals(cart.totalPrice(), 500);
        cart.removeProduct(apple, 3);
        cart.removeProduct(apple);
        assertThrows(IllegalStateException.class, () -> cart.removeProduct(pineapple));
        assertEquals(cart.getQuantity(pineapple), 0);
        assertEquals(cart.totalPrice(), 100);
        cart.addProduct(banana);
        assertTrue(cart.containsProduct(apple));
        cart.removeAll();
        assertTrue(cart.isEmpty());
    }

    @Test
    void test2() {
        cart.addProduct(banana);
        cart.addProduct(apple, 3);
        cart.addProduct(pineapple, 2);
        assertEquals(cart.toString(),"{Product{name='Banana', price=50.0}=1, Product{name='Apple', price=100.0}=3, Product{name='Pineapple', price=200.0}=2}");
    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        cart.removeAll();
    }
}