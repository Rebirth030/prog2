package de.hhn.prog2.lab04.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Stellt eine Pizza da
 */
public class Pizza {
    private int price;
    private PizzaSize size;
    private ArrayList<PizzaTopping> pizzaToppings;
    private static HashMap<PizzaSize, Integer> priceList;

    public Pizza(PizzaSize size, ArrayList<PizzaTopping> pizzaToppings) {
        this.size = size;
        this.pizzaToppings = pizzaToppings;
        price = calcPrice(size, pizzaToppings.size());
    }

    /**
     * Berechnet den Preis der Pizza
     * @param size PizzaSize
     * @param toppings Integer
     * @return Preis in cent (Integer)
     */
    private static int calcPrice(PizzaSize size, int toppings) {
        int sum;
        priceList = new HashMap<>();
        priceList.put(PizzaSize.SMALL, 500);
        priceList.put(PizzaSize.MEDIUM, 600);
        priceList.put(PizzaSize.LARGE, 800);
        priceList.put(PizzaSize.EXTRA_LARGE, 1100);

        sum = priceList.get(size);
        sum += toppings * 50;
        return sum;
    }

    public int getPrice() {
        return price;
    }

    public PizzaSize getSize() {
        return size;
    }

    public ArrayList<PizzaTopping> getToppings() {
        return pizzaToppings;
    }
}
