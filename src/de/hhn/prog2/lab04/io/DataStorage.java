package de.hhn.prog2.lab04.io;
import de.hhn.prog2.lab04.model.*;

import java.io.*;
import java.util.Scanner;


public class DataStorage {

    public void writeOrderCSV(Order order){
        try {
            FileWriter fileWriter = new FileWriter("Bestellung.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.toString() + " \n");
            for (Pizza pizza:order.getPizzas()) {
                stringBuilder.append(pizza.getSize() + " ; " + pizza.getToppings().toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Order readOrderCSV(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("name.csv");
             bufferedReader = new BufferedReader(fileReader);
            Scanner s = new Scanner(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Order order =
        return
    }
}
