package lab09.view;

import javax.swing.*;

public class frame {
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
        configPanel.createPizzaConfigPanel(jFrame);
        menuBar.addJMenuBar(jFrame);
        jFrame.setVisible(true);
    }
}
