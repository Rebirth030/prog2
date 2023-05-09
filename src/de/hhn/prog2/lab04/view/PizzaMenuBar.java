package de.hhn.prog2.lab04.view;

import javax.swing.*;

public class PizzaMenuBar {
    private static JMenuItem beenden;
    private static JMenuItem lesen;
    private static JMenuItem speichern;
    private static JMenuItem currentOrder;
    private static JMenu chooseCurrentOrder;

    /**
     * Erstellt eine JMenuBar und fügt diese zum JFrame hinzu.
     * @param frame JFrame
     */
    public static void addJMenuBar(JFrame frame){

        JMenuBar jMenuBar = new JMenuBar();
        JMenu data = new JMenu("Datei");
        JMenu order = new JMenu("Bestellung");
        JMenu help = new JMenu("Hilfe");

        initData(data);
        initOrder(order);

        jMenuBar.add(data);
        jMenuBar.add(order);
        jMenuBar.add(help);
        frame.setJMenuBar(jMenuBar);
    }

    /**
     * Initialisiert die Unterpunkte für Dateien
     * @param data JMenu
     */
    private static void initData(JMenu data) {
        beenden = new JMenuItem("Beenden");
        data.add(beenden);
    }

    /**
     * Initialisiert die Unterpunkte für Bestellung
     * @param order JMenu
     */
    private static void initOrder(JMenu order){
        lesen = new JMenuItem("Lesen");
        order.add(lesen);

        speichern = new JMenuItem("Speichern");
        order.add(speichern);

        chooseCurrentOrder = new JMenu("Bestellung Auswählen");
        order.add(chooseCurrentOrder);

        currentOrder = new JMenuItem("Bestellung: " + 0);
        order.add(currentOrder);
    }

    public static JMenuItem getBeenden() {
        return beenden;
    }

    public static JMenuItem getLesen() {
        return lesen;
    }

    public static JMenuItem getSpeichern() {
        return speichern;
    }

    public static JMenu getChooseCurrentOrder() {
        return chooseCurrentOrder;
    }

    public static JMenuItem getCurrentOrder() {
        return currentOrder;
    }
}
