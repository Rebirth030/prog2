package de.hhn.prog2.lab04.view;

import javax.swing.*;

public class PizzaFrame {
    private static JFrame jFrame;

    /**
     * Erstellt das JFrame und Addet alles nötige
     */
    public static void createGUI() {
        jFrame = new JFrame();
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("Pizza Editor");
        jFrame.setResizable(true);
        PizzaConfigPanel.createPizzaConfigPanel(jFrame);
        PizzaMenuBar.addJMenuBar(jFrame);
        jFrame.setVisible(true);
    }
}
