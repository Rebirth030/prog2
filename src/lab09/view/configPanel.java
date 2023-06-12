package lab09.view;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Klasse zum Erstellen der JPanels
 */
public class configPanel {

    private static JButton load;
    private static JButton save;
    private static JComboBox<String> comboBox;
    /**
     * Erstellt die Haupt-JPanels und addet diese zum JFrame
     * @param frame JFrame
     */
    public static void createPizzaConfigPanel(JFrame frame) {
        DateFormat Date_Format = new SimpleDateFormat("dd MMM yyyy");
        JPanel panel = new JPanel(new GridLayout(6, 2));


        JTextField textField = new JTextField();
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JFormattedTextField Today_Date = new JFormattedTextField(Date_Format);

        JLabel label = new JLabel("Kunde");
        JLabel label1 = new JLabel("Vorname");
        JLabel label2 = new JLabel("Nachname");
        JLabel label3 = new JLabel("Geburtsdatum");
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        load = new JButton("Laden");
        save = new JButton("Speichern");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
        comboBox = new JComboBox<>(new String[]{"de_DE", "en"});
        panel2.add(comboBox);
        panel3.setLayout(flowLayout);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(label);
        panel.add(panel4);
        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(textField1);
        panel.add(label3);
        panel.add(textField2);
        panel.add(load);
        panel.add(save);



        frame.add(panel);

    }



    /**
     * fügt die rechte Seite des Fensters zum pPanel3 Hinzu
     * (Bild und Fertig/Beenden Button)
     * @param pPanel3 JPanel
     */
    public static void addToPnl3(JPanel pPanel3) {

        JPanel pPanel4 = new JPanel();

        pPanel4.add(load);
        pPanel4.add(save);

        pPanel3.add(pPanel4);
    }

    /**
     *Setzt das Panel auf die Ursprungseinstellungen zurück
     */

    public static JButton getDoneButton() {
        return load;
    }

    public static JButton getEndButton() {
        return save;
    }
}
