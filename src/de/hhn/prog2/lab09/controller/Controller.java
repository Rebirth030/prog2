package de.hhn.prog2.lab09.controller;

import de.hhn.prog2.lab09.io.DataManager;
import de.hhn.prog2.lab09.model.Customer;
import de.hhn.prog2.lab09.view.configPanel;
import de.hhn.prog2.lab09.view.frame;
import de.hhn.prog2.lab09.view.menuBar;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Formatter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.*;


/**
 * Main Klasse
 */
public class Controller {
    public static void main(String[] args) {
        frame.createGUI(Locale.of("de_DE"));
        setSaveAction();
        setLoadAction();
        setJMenuBarActions();
        setLanguage();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     */

    public static void setLoadAction() {
        configPanel.getLoadButton().addActionListener(e -> {
            try {
                Customer customer = DataManager.loadCustomer();
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
                formatter.withLocale(Locale.of("en"));
                configPanel.getTextField().setText(customer.getPrename());
                configPanel.getTextField1().setText(customer.getLastname());
                configPanel.getDate().setText(formatter.format(LocalDate.of(2002,11,22)));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /**
     * Setzt den ActionListener für die JMenuBar Items
     */
    public static void setSaveAction() {
        configPanel.getSaveButton().addActionListener(e -> {
            try {
                Customer customer = new Customer(configPanel.getTextField().getText(), configPanel.getTextField1().getText(), LocalDate.parse(configPanel.getDate().getText()));
                DataManager.saveCustomer(customer);
                JOptionPane.showMessageDialog(configPanel.getSaveButton().getTopLevelAncestor(),configPanel.getBundle().getString("MessageBest"));
            } catch (NoSuchElementException | DateTimeParseException k){
                k.printStackTrace();
                JOptionPane.showMessageDialog(configPanel.getSaveButton().getTopLevelAncestor(),configPanel.getBundle().getString("MessageDate"));
            }
        });
    }

    /**
     * Methode zum Setzen von MenuItemFunktionen
     */
    private static void setJMenuBarActions() {
        menuBar.getBeenden().addActionListener(e -> System.exit(0));
    }

    private static void setLanguage() {
        configPanel.getComboBox().addActionListener(e -> {
            Locale locale = Locale.of(Objects.requireNonNull(configPanel.getComboBox().getSelectedItem()).toString());
            frame.getjFrame().dispose();
            frame.createGUI(locale);
            configPanel.getComboBox().setSelectedItem(locale.toString());
            setSaveAction();
            setLoadAction();
            setJMenuBarActions();
            setLanguage();
        });
    }
}
