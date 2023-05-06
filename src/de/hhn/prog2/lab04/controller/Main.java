package de.hhn.prog2.lab04.controller;

import de.hhn.prog2.lab04.model.Order;
import de.hhn.prog2.lab04.model.Pizza;
import de.hhn.prog2.lab04.view.PizzaConfigPanel;
import de.hhn.prog2.lab04.view.PizzaFrame;
import de.hhn.prog2.lab04.view.PizzaMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Main Klasse
 */
public class Main {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        PizzaFrame.createGUI();
        orders.add(new Order(orders.size()));
        setDoneAction(orders.size() - 1);
        setEndAction();
        setJMenuBarActions();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     * @param orderId Integer
     */

    public static void setDoneAction(int orderId) {
        PizzaConfigPanel.getDoneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(PizzaConfigPanel.getSize(), PizzaConfigPanel.getToppings());
                /*System.out.println(
                        "OrderID: " + orders.get(orders.size() - 1).getOrderId() + "\n"
                                + "Pizzas: " + orders.get(orders.size() - 1).getPizzas().toString() + "\n"
                                + "Pizza größe: " + pizza.getSize() + "\n"
                                + "Pizza Preis: " + pizza.getPrice() + "\n"
                                + "Pizza Topping: " + pizza.getToppings().toString()
                );*/
                int n = JOptionPane.showConfirmDialog(PizzaConfigPanel.getDoneButton().getTopLevelAncestor(), "Die Pizza kostet: " + (double)pizza.getPrice() / 100d + "€ \n Zur Bestellung Hinzufügen?", "Confirm Pizza Configuration",
                        JOptionPane.YES_NO_OPTION);
                System.out.println("Selected option:" + n);

                if (n == JOptionPane.YES_OPTION) {
                    orders.get(orderId).addPizza(pizza);
                    PizzaConfigPanel.resetPanel();
                }
            }
        });
    }

    /**
     * Setzt den ActionListener für den Beenden Button
     */
    public static void setEndAction() {
        PizzaConfigPanel.getEndButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(PizzaConfigPanel.getDoneButton().getTopLevelAncestor(), "Willst du wirklich beenden", "Confirm Leaving",
                        JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Methode zum Setzen von MenuItemFunktionen (Hier nur beenden)
     */
    private static void setJMenuBarActions() {
        PizzaMenuBar.getBeenden().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(PizzaConfigPanel.getDoneButton().getTopLevelAncestor(), "Willst du wirklich beenden", "Confirm Leaving",
                        JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


    }

}
