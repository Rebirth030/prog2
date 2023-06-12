package lab09.controller;

import lab09.view.configPanel;
import lab09.view.frame;
import lab09.view.menuBar;

import javax.swing.*;


/**
 * Main Klasse
 */
public class Controller {
    public static void main(String[] args) {
        frame.createGUI();
        setDoneAction();
        setEndAction();
        setJMenuBarActions();
    }

    /**
     * Setzt den ActionListener vom Fertig Button
     */

    public static void setDoneAction() {
        configPanel.getDoneButton().addActionListener(e -> {


            int n = JOptionPane.showConfirmDialog(configPanel.getDoneButton().getTopLevelAncestor(), "Die Pizza kostet: ", "Confirm Pizza Configuration",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {

            }
        });
    }

    /**
     * Setzt den ActionListener für die JMenuBar Items
     */
    public static void setEndAction() {
        configPanel.getEndButton().addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(configPanel.getDoneButton().getTopLevelAncestor(), "Willst du wirklich beenden", "Confirm Leaving",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    /**
     * Methode zum Setzen von MenuItemFunktionen
     */
    private static void setJMenuBarActions() {
        menuBar.getBeenden().addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(configPanel.getDoneButton().getTopLevelAncestor(), "Willst du wirklich beenden", "Confirm Leaving",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }
}
