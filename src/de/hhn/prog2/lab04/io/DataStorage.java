package de.hhn.prog2.lab04.io;

import de.hhn.prog2.lab04.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataStorage {
    private static final String FILE_PATH_CSV = "src/de/hhn/prog2/lab04/io/Bestellung.csv";
    private static final String FILE_PATH_BIN = "src/de/hhn/prog2/lab04/io/Bestellung.bin";
    private static String STORAGE_FORMAT = "binary";

    /**
     * Ruft eine der Write Methoden auf, abhängig vom Wert der Variable STORAGE_FORMAT
     * @param order Order
     */
    public static void writeOrder(Order order){
        if(STORAGE_FORMAT.equals("binary")) writeOrderBin(order);
        else writeOrderCSV(order);
    }

    /**
     * Ruft eine der Read Methoden auf, abhängig vom Wert der Variable STORAGE_FORMAT
     * @param orderId long
     */
    public static Order readOrder(long orderId) throws FileNotFoundException{
        if (STORAGE_FORMAT.equals("binary")) return readOrderBin(orderId);
        else return readOrderCSV(orderId);
    }

    /**
     * Schreibt die Informationen einer Order in eine CSV Datei.
     * @param order Order
     */
    public static void writeOrderCSV(Order order) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH_CSV);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(order.toString() + "\n");

            for (Pizza pizza : order.getPizzas()) {
                bufferedWriter.write(pizza.getSize() + ";");
                for (PizzaTopping pizzaTopping : pizza.getToppings()) {
                    bufferedWriter.write(pizzaTopping + ";");
                }
                bufferedWriter.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                close(bufferedWriter);
            }
            if (fileWriter != null) {
                close(fileWriter);
            }
        }
    }

    /**
     * liest die Informationen einer Order aus einer CSV Datei ein.
     * @param orderId long
     */
    public static Order readOrderCSV(long orderId) throws FileNotFoundException {
        FileReader fileReader = new FileReader(FILE_PATH_CSV);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner s = new Scanner(bufferedReader);
        Order order = retrieveOrder(s, orderId);
        close(bufferedReader);
        close(fileReader);
        return order;
    }

    /**
     * Schreibt die Informationen einer Order in eine BIN Datei.
     * @param order Order
     */
    public static void writeOrderBin(Order order) {
        DataOutputStream os = null;
        BufferedOutputStream bufferedOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILE_PATH_BIN);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            os = new DataOutputStream(bufferedOutputStream);

            os.writeBytes(order.toString() + "\n");

            for (Pizza pizza : order.getPizzas()) {
                os.writeBytes(pizza.getSize() + ";");
                for (PizzaTopping pizzaTopping : pizza.getToppings()) {
                    os.writeBytes(pizzaTopping + ";");
                }
                os.writeBytes("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                close(bufferedOutputStream);
            }
            if (fileOutputStream != null) {
                close(fileOutputStream);
            }
            if (os != null) {
                close(os);
            }
        }

    }

    /**
     * liest die Informationen einer Order aus einer BIN Datei ein.
     * @param orderId long
     */
    public static Order readOrderBin(long orderId) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH_BIN);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        Scanner s = new Scanner(dataInputStream);
        Order order = retrieveOrder(s,orderId);
        close(fileInputStream);
        close(bufferedInputStream);
        close(dataInputStream);
        return order;
    }

    /**
     * liest den Text eines Scanners so ein, dass sie die Infomationen als Order abspeichern kann und returnt diese Order
     * @param s Scanner
     * @param orderId long
     * @return Order
     */
    private static Order retrieveOrder(Scanner s,long orderId){
        Order order = null;
        Scanner d;
        while (s.hasNext()) {
            d = new Scanner(s.next());
            d.useDelimiter(";");
            PizzaSize size = null;
            ArrayList<PizzaTopping> toppings = new ArrayList<>();
            while (d.hasNext()) {
                String temp = d.next();
                if (temp.contains("de.hhn.prog2.lab04.model.Order@")) order = new Order(orderId);
                else if (temp.contains("SMALL") || temp.contains("MEDIUM") || temp.contains("LARGE") || temp.contains("EXTRA_LARGE"))
                    size = PizzaSize.valueOf(temp);
                else toppings.add(PizzaTopping.valueOf(temp));


            }
            d.close();
            if (order != null && size != null) {
                order.addPizza(new Pizza(size, toppings));
            }
        }
        return order;
    }

    /**
     * Eine Methode um alle closable Objekte zu schließen, falls sie nicht null sind.
     * @param closeable Closable
     */
    private static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
