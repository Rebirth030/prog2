package de.hhn.prog2.lab04.view;

import javax.swing.*;
import java.awt.*;

/**
 * The Gui class creates the Gui of the game.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class Gui {
    /**
     * The object pnl1 from the Panel class.
     */
    static Panel pnl1;
    /**
     * The object jf from the JFrame class
     */
    static JFrame jf;

    /**
     * creates the Gui.
     * <p>
     * First a JFrame named jf gets added.
     * <p>
     * I don't think there is something to miss understand in the rest of the code.
     */
    public static void createGui() {

        jf = new JFrame();
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jf.setUndecorated(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setTitle("Pizza");
        jf.setResizable(true);
        jf.requestFocus();
        jf.setVisible(true);

        pnl1 = new Panel();
        pnl1.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        pnl1.setVisible(true);
        jf.add(pnl1);

    }
}