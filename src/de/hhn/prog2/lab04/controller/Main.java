package de.hhn.prog2.lab04.controller;

import de.hhn.prog2.lab04.io.DataStorage;
import de.hhn.prog2.lab04.model.Order;
import de.hhn.prog2.lab04.model.Pizza;
import de.hhn.prog2.lab04.model.PizzaTopping;
import de.hhn.prog2.lab04.view.PizzaConfigPanel;
import de.hhn.prog2.lab04.view.PizzaFrame;
import de.hhn.prog2.lab04.view.PizzaMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Main Klasse
 */
public class Main {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static long currentOrderId = 0;
    public static void main(String[] args) {
        PizzaFrame.createGUI();
        orders.add(new Order(currentOrderId));
        setDoneAction();
        setEndAction();
        setJMenuBarActions();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     */

    public static void setDoneAction() {
        PizzaConfigPanel.getDoneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(PizzaConfigPanel.getSize(), PizzaConfigPanel.getToppings());

                int n = JOptionPane.showConfirmDialog(PizzaConfigPanel.getDoneButton().getTopLevelAncestor(), "Die Pizza kostet: " + (double)pizza.getPrice() / 100d + "€ \n Zur Bestellung Hinzufügen?", "Confirm Pizza Configuration",
                        JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    orders.get((int) currentOrderId).addPizza(pizza);
                    PizzaConfigPanel.resetPanel();
                }
            }
        });
    }

    /**
     * Setzt den ActionListener für die JMenuBar Items
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
     * Methode zum Setzen von MenuItemFunktionen
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

        PizzaMenuBar.getLesen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long orderId = orders.size();
                    orders.add(DataStorage.readOrderCSV(orderId));
                    PizzaMenuBar.getChooseCurrentOrder().add(new JMenuItem(String.valueOf(orderId))).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        currentOrderId = orderId;
                        PizzaMenuBar.getCurrentOrder().setText("Bestellung: " + currentOrderId);
                        }
                    });
                    JOptionPane.showMessageDialog(PizzaMenuBar.getLesen().getTopLevelAncestor(),makeNiceDialogReturn(orders.get((int) orderId)));
                } catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(PizzaMenuBar.getLesen().getTopLevelAncestor(),"Es wurden keine gespeicherten Informationen gefunden");
                }
            }
        });

        PizzaMenuBar.getSpeichern().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataStorage.writeOrderCSV(orders.get((int) currentOrderId));
            }
        });

        addOrderChoosing();
    }

    /**
     * Fügt MenuItems mit Actionlistenern zu bestellung Auswählen hinzu.
     * Es werden so viele Items erstellt, wie es bestellungen gibt;
     * Implementierung, falls man später von anfang an mit mehreren Bestellungen arbeitet
     */
    private static void addOrderChoosing() {
        for (Order order : orders) {
            PizzaMenuBar.getChooseCurrentOrder().add(new JMenuItem(String.valueOf(order.getId()))).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentOrderId = order.getId();
                    PizzaMenuBar.getCurrentOrder().setText("Bestellung: " + currentOrderId);
                }
            });
        }
    }

    private static String makeNiceDialogReturn(Order order) {
        StringBuilder stringBuilder = new StringBuilder("Bestellung: " + orders.indexOf(order));
        for (Pizza pizza: order.getPizzas()){
            stringBuilder.append("\nPizza: ");
            stringBuilder.append(PizzaConfigPanel.getToppingSizes().get(pizza.getSize())).append(", Toppings: ");
            for (PizzaTopping pizzaTopping : pizza.getToppings()) {
                stringBuilder.append(PizzaConfigPanel.getToppingNames().get(pizzaTopping)).append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
