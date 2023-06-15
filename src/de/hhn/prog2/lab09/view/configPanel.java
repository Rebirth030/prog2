package de.hhn.prog2.lab09.view;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * Klasse zum Erstellen der JPanels
 */
public class configPanel {

    private static JButton load;
    private static JButton save;
    private static  JComboBox<String> comboBox;
    private static ResourceBundle bundle;

    /**
     * Erstellt die Haupt-JPanels und addet diese zum JFrame
     *
     * @param frame JFrame
     */
    public static void createPanel(JFrame frame,Locale locale) {
        Locale german = Locale.of("de", "DE");
        Locale english = Locale.of("en");

        comboBox = new JComboBox<>(new String[]{german.toString(),english.toString()});
        comboBox.setSelectedItem(locale.toString());

        bundle = ResourceBundle.getBundle("MessageBundle", locale);

        DateFormat Date_Format = new SimpleDateFormat("dd MMM yyyy");
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField textField = new JTextField();
        JTextField textField1 = new JTextField();
        JFormattedTextField date = new JFormattedTextField(Date_Format);

        JLabel label = new JLabel(bundle.getString("Kunde"));
        label.setFont(new Font(bundle.getString("Kunde"), Font.BOLD, 40));
        JLabel label1 = new JLabel(bundle.getString("Vorname"));
        JLabel label2 = new JLabel(bundle.getString("Nachname"));
        JLabel label3 = new JLabel(bundle.getString("Geburtsdatum"));
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        load = new JButton(bundle.getString("Laden"));
        save = new JButton(bundle.getString("Speichern"));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
        panel3.add(comboBox);
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
        panel.add(date);
        panel.add(load);
        panel.add(save);


        frame.add(panel);

    }

    public static JButton getDoneButton() {
        return load;
    }

    public static JButton getEndButton() {
        return save;
    }

    public static JComboBox<String> getComboBox() {
        return comboBox;
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }
}
