package de.hhn.prog2.lab04.view;

import de.hhn.prog2.lab04.model.*;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Klasse zum Erstellen der JPanels
 */
public class PizzaConfigPanel {
    private static final PizzaSize[] pizzaSizes = PizzaSize.values();
    private static String[] translatedPizzaSizes = new String[pizzaSizes.length];
    private static final PizzaTopping[] pizzaToppings = PizzaTopping.values();

    private static JButton done;
    private static JButton end;

    private static final JCheckBox[] checkBoxes = new JCheckBox[pizzaToppings.length];
    private static JComboBox<String> comboBox;

    private static HashMap<PizzaTopping, String> toppingNames;
    private static HashMap<PizzaSize, String> toppingSizes;

    /**
     * Erstellt die Haupt-JPanels und addet diese zum JFrame
     * @param frame JFrame
     */
    public static void createPizzaConfigPanel(JFrame frame) {
        JPanel pPanel = new JPanel(new GridLayout(1, 2));

        JPanel pPanel2 = new JPanel();
        JPanel pPanel3 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(pPanel2, BoxLayout.Y_AXIS);
        pPanel2.setLayout(boxLayout);
        BoxLayout boxLayout2 = new BoxLayout(pPanel3, BoxLayout.Y_AXIS);
        pPanel3.setLayout(boxLayout2);
        addToPnl2(pPanel2);
        pPanel.add(pPanel2);
        addToPnl3(pPanel3);
        pPanel.add(pPanel3);
        pPanel.repaint();

        frame.add(pPanel);

    }

    /**
     * Fügt die linke Hälfte des Fensters zum pPanel2 (Pizza Panel2 :)) hinzu.
     * (JLabels, JComboBox und JCheckBoxen)
     * @param pPanel2 JPanel
     */
    public static void addToPnl2(JPanel pPanel2) {
        initHashMaps();
        JLabel label1 = new JLabel("Größe:");
        comboBox = new JComboBox<>(translatedPizzaSizes);
        comboBox.setMaximumSize(new Dimension(100, 25));


        JLabel label2 = new JLabel("Zutaten:");
        pPanel2.add(label1);
        pPanel2.add(comboBox);
        pPanel2.add(label2);

        for (int i = 0; i < pizzaToppings.length; i++) {
            checkBoxes[i] = new JCheckBox(toppingNames.get(pizzaToppings[i]));
            pPanel2.add(checkBoxes[i]);
        }
    }

    /**
     * fügt die rechte Seite des Fensters zum pPanel3 Hinzu
     * (Bild und Fertig/Beenden Button)
     * @param pPanel3 JPanel
     */
    public static void addToPnl3(JPanel pPanel3) {
        Image myPicture;
        try {
            myPicture = ImageIO.read(new File("rsc/pizzaPic.jpg")).getScaledInstance(500, 250, 0);
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setSize(pPanel3.getWidth() / 2, pPanel3.getHeight() / 4);
            pPanel3.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel pPanel4 = new JPanel();
        done = new JButton("Fertig");
        end = new JButton("Ende");
        pPanel4.add(done);
        pPanel4.add(end);

        pPanel3.add(pPanel4);
    }

    /**
     * Initialisiert die Hashmaps zum Übersetzen und das Array mit den Übersetzten größen, für die JComboBox
     */
    private static void initHashMaps() {
        toppingNames = new HashMap<>();
        toppingNames.put(PizzaTopping.ANANAS, "Ananas");
        toppingNames.put(PizzaTopping.CHEESE, "Käse");
        toppingNames.put(PizzaTopping.HAM, "Schinken");
        toppingNames.put(PizzaTopping.NUTELLA, "Nutella");
        toppingNames.put(PizzaTopping.SALAMI, "Salami");
        toppingNames.put(PizzaTopping.SEAFOOD, "Meeresfrüchte");
        toppingNames.put(PizzaTopping.SOUR_CREAM, "Sour Cream");
        toppingNames.put(PizzaTopping.TOMATO, "Tomate");
        toppingNames.put(PizzaTopping.VEGETABLES, "Gemüse");

        toppingSizes = new HashMap<>();
        toppingSizes.put(PizzaSize.SMALL, "Klein");
        toppingSizes.put(PizzaSize.MEDIUM, "Mittel");
        toppingSizes.put(PizzaSize.LARGE, "Groß");
        toppingSizes.put(PizzaSize.EXTRA_LARGE, "Extragroß");

        for (int i = 0; i < pizzaSizes.length; i++) {
            translatedPizzaSizes[i] = toppingSizes.get(pizzaSizes[i]);
        }
    }

    /**
     *Setzt das Panel auf die Ursprungseinstellungen zurück
     */
    public static void resetPanel() {
        for (JCheckBox checkBox: checkBoxes) {
            checkBox.setSelected(false);
        }
        comboBox.setSelectedItem("Klein");

    }

    public static JButton getDoneButton() {
        return done;
    }

    public static JButton getEndButton() {
        return end;
    }

    public static ArrayList<PizzaTopping> getToppings() {
        ArrayList<PizzaTopping> toppings = new ArrayList<PizzaTopping>();
        for (int i = 0; i< checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                toppings.add(pizzaToppings[i]);
            }
        }
        return toppings;
    }

    public static PizzaSize getSize() {
        return pizzaSizes[comboBox.getSelectedIndex()];
    }

    public static HashMap<PizzaTopping, String> getToppingNames() {
        return toppingNames;
    }

    public static HashMap<PizzaSize, String> getToppingSizes() {
        return toppingSizes;
    }
}
