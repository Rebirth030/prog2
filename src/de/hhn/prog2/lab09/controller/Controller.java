package de.hhn.prog2.lab09.controller;

import de.hhn.prog2.lab09.io.DataManager;
import de.hhn.prog2.lab09.model.Customer;
import de.hhn.prog2.lab09.view.ConfigPanel;
import de.hhn.prog2.lab09.view.Frame;
import de.hhn.prog2.lab09.view.MenuBar;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;


/**
 * Main Klasse
 */
public class Controller {
    public static void main(String[] args) {
        Frame.createGUI(Locale.of("de_DE"));
        setSaveAction();
        setLoadAction();
        setJMenuBarActions();
        setLanguage();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     * Es scheint so, als wäre von der API her, LocalDate von deutschland mit england gleich, weil der formatter auf Locale = en dasselbe ausgibt wie bei Locale = de_DE
     */

    public static void setLoadAction() {
        ConfigPanel.getLoadButton().addActionListener(e -> {
            try {
                Customer customer = DataManager.loadCustomer();
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
                formatter.withLocale(ConfigPanel.getLocale());
                ConfigPanel.getTextField().setText(customer.getPrename());
                ConfigPanel.getTextField1().setText(customer.getLastname());
                ConfigPanel.getDate().setText(formatter.format(customer.getDateOfBirth()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /**
     * Setzt den ActionListener für die JMenuBar Items
     */
    public static void setSaveAction() {
        ConfigPanel.getSaveButton().addActionListener(e -> {
            if (!(ConfigPanel.getTextField().getText().isEmpty()&&ConfigPanel.getTextField1().getText().isEmpty()&&ConfigPanel.getDate().getText().isEmpty())) {
                try {
                    DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    Customer customer = new Customer(ConfigPanel.getTextField().getText(), ConfigPanel.getTextField1().getText(), LocalDate.parse(ConfigPanel.getDate().getText(), dt));
                    DataManager.saveCustomer(customer);
                    JOptionPane.showMessageDialog(ConfigPanel.getSaveButton().getTopLevelAncestor(), ConfigPanel.getBundle().getString("MessageBest"));
                } catch (NoSuchElementException | DateTimeParseException k) {
                    JOptionPane.showMessageDialog(ConfigPanel.getSaveButton().getTopLevelAncestor(), ConfigPanel.getBundle().getString("MessageDate"));
                }
            } else {
                JOptionPane.showMessageDialog(ConfigPanel.getSaveButton().getTopLevelAncestor(), ConfigPanel.getBundle().getString("MessageEmpty"));
            }
        });
    }

    /**
     * Methode zum Setzen von MenuItemFunktionen
     */
    private static void setJMenuBarActions() {
        MenuBar.getBeenden().addActionListener(e -> System.exit(0));
    }

    /**
     * sorgt dafür, das beim Auswählen einer Sprache ein neues JFrame in der richtigen Sprache geöffnet wird
     */
    private static void setLanguage() {
        ConfigPanel.getComboBox().addActionListener(e -> {
            Locale locale = Locale.of(Objects.requireNonNull(ConfigPanel.getComboBox().getSelectedItem()).toString());
            Frame.getjFrame().dispose();
            Frame.createGUI(locale);
            ConfigPanel.getComboBox().setSelectedItem(locale.toString());
            setSaveAction();
            setLoadAction();
            setJMenuBarActions();
            setLanguage();
        });
    }
}
