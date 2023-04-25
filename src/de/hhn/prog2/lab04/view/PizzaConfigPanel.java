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
import java.util.HashMap;

public class PizzaConfigPanel {
    private final PizzaSize[] pizzaSizes = PizzaSize.values();
    private final PizzaTopping[] pizzaToppings = PizzaTopping.values();

    private BufferedImage myPicture;

    private JCheckBox[] checkBoxes = new JCheckBox[pizzaToppings.length];

    public PizzaConfigPanel(JFrame frame) {
        JPanel pPanel = new JPanel(new GridLayout(1,2));
        frame.add(pPanel);

        JPanel pPanel2 = new JPanel();
        JPanel pPanel3 = new JPanel();
        pPanel2.setLayout(new BoxLayout(pPanel2,BoxLayout.PAGE_AXIS));
        pPanel3.setLayout(new SpringLayout());
        addToPnl2(pPanel2);
        pPanel.add(pPanel2);
        addToPnl3(pPanel3);
        pPanel.add(pPanel3);


    }

    public void addToPnl2(JPanel pPanel2) {
        JLabel label1 = new JLabel("Größe:");
        JComboBox<PizzaSize> comboBox = new JComboBox<>(pizzaSizes);
        pPanel2.add(label1);
        pPanel2.add(comboBox);

        for (int i = 0; i <= pizzaToppings.length; i++) {
            checkBoxes[i] = new JCheckBox(String.valueOf(pizzaToppings[i]));
            pPanel2.add(checkBoxes[i]);
        }
    }

    public void addToPnl3(JPanel pPanel3) {
        try {
            myPicture = ImageIO.read(new File("rsc/1a-pizza-jpg"));
        } catch (IOException e){
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(pPanel3.getWidth()/2,pPanel3.getHeight()/4);
        pPanel3.add(picLabel);
        JButton done = new JButton("Fertig");
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
