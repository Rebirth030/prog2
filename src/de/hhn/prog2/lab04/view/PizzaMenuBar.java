package de.hhn.prog2.lab04.view;

import javax.swing.*;

public class PizzaMenuBar {
    private static JMenuItem beenden;

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

        jMenuBar.add(data);
        jMenuBar.add(order);
        jMenuBar.add(help);
        frame.setJMenuBar(jMenuBar);
    }

    /**
     * Initialisiert die Unterpunkte für Dateien
     * @param data
     */
    private static void initData(JMenu data) {
        beenden = new JMenuItem("Beenden");
        data.add(beenden);
    }

    public static JMenuItem getBeenden() {
        return beenden;
    }

}
