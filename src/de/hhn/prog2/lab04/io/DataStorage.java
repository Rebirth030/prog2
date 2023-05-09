package de.hhn.prog2.lab04.io;

import de.hhn.prog2.lab04.model.*;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataStorage {
    private static String filePath = "src/de/hhn/prog2/lab04/io/Bestellung.csv";

    public static void writeOrderCSV(Order order) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(order.toString() +"\n");

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

    public static Order readOrderCSV(long orderId) throws FileNotFoundException{
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Order order = null;
            fileReader = new FileReader(filePath);
             bufferedReader = new BufferedReader(fileReader);
            Scanner s = new Scanner(bufferedReader);
            Scanner d;
            while (s.hasNext()) {
                d = new Scanner(s.next());
                d.useDelimiter(";");
                PizzaSize size = null;
                ArrayList<PizzaTopping> toppings = new ArrayList<>();
                while (d.hasNext()){
                    String temp = d.next();
                    if (temp.contains("de.hhn.prog2.lab04.model.Order@")) order = new Order(orderId);
                    else if (temp.contains("SMALL") || temp.contains("MEDIUM") || temp.contains("LARGE") || temp.contains("EXTRA_LARGE")) size = PizzaSize.valueOf(temp);
                    else toppings.add(PizzaTopping.valueOf(temp));


                }
                d.close();
                if (order != null && size != null) {
                    order.addPizza(new Pizza(size, toppings));
                }
            }
        close(bufferedReader);
        close(fileReader);
        return order;
    }
    private static void close(Closeable closeable){
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
