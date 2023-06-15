package de.hhn.prog2.lab09.controller;

import de.hhn.prog2.lab09.view.configPanel;
import de.hhn.prog2.lab09.view.frame;
import de.hhn.prog2.lab09.view.menuBar;

import javax.swing.*;
import java.util.Locale;
import java.util.Objects;


/**
 * Main Klasse
 */
public class Controller {
    public static void main(String[] args) {
        frame.createGUI(Locale.of("de_DE"));
        setDoneAction();
        setEndAction();
        setJMenuBarActions();
        setLanguage();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     */

    public static void setDoneAction() {
        configPanel.getDoneButton().addActionListener(e -> {

        });
    }

    /**
     * Setzt den ActionListener für die JMenuBar Items
     */
    public static void setEndAction() {
        configPanel.getEndButton().addActionListener(e -> {
            System.exit(0);
        });
    }

    /**
     * Methode zum Setzen von MenuItemFunktionen
     */
    private static void setJMenuBarActions() {
        menuBar.getBeenden().addActionListener(e -> {
            System.exit(0);
        });
    }

    private static void setLanguage() {
        configPanel.getComboBox().addActionListener(e -> {
            Locale locale = Locale.of(Objects.requireNonNull(configPanel.getComboBox().getSelectedItem()).toString());
            frame.getjFrame().dispose();
            frame.createGUI(locale);
            configPanel.getComboBox().setSelectedItem(locale.toString());
            setDoneAction();
            setEndAction();
            setJMenuBarActions();
            setLanguage();
        });
    }
}
