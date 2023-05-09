package de.hhn.prog2.lab04.model;

import java.util.ArrayList;

/**
 * Stellt eine Order da
 */
public class Order {
    private final long orderId;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order(long orderId){
        this.orderId = orderId;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public long getId() {return orderId;}
}
