package de.hhn.prog2.lab09.view;

import javax.swing.*;

public class MenuBar {
    private static JMenuItem beenden;
    /**
     * Erstellt eine JMenuBar und fügt diese zum JFrame hinzu.
     * @param frame JFrame
     */
    public static void addJMenuBar(JFrame frame){

        JMenuBar jMenuBar = new JMenuBar();
        JMenu data = new JMenu(ConfigPanel.getBundle().getString("Datei"));

        initData(data);

        jMenuBar.add(data);

        frame.setJMenuBar(jMenuBar);
    }

    /**
     * Initialisiert die Unterpunkte für Dateien
     * @param data JMenu
     */
    private static void initData(JMenu data) {
        beenden = new JMenuItem(ConfigPanel.getBundle().getString("Beenden"));
        data.add(beenden);
    }

    public static JMenuItem getBeenden() {
        return beenden;
    }


}
