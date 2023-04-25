package de.hhn.prog2.lab04.model;

import java.util.ArrayList;

public class Order {
    private long orderId;
    private ArrayList<Pizza> pizzas;

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }
}
