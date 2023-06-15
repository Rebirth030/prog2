package de.hhn.prog2.lab09.view;

import javax.swing.*;
import java.util.Locale;

public class frame {
    private static JFrame jFrame;

    /**
     * Erstellt das JFrame und Addet alles nötige
     */
    public static void createGUI(Locale locale) {
        jFrame = new JFrame();
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(true);
        configPanel.createPanel(jFrame, locale);
        menuBar.addJMenuBar(jFrame);
        jFrame.setTitle(configPanel.getBundle().getString("Eingabe"));
        jFrame.setVisible(true);
    }

    public static JFrame getjFrame() {
        return jFrame;
    }
}
