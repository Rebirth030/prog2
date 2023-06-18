package de.hhn.prog2.lab09.io;

import de.hhn.prog2.lab09.model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DataManager {
    private static final String FILE_PATH_CSV = "src/de/hhn/prog2/lab09/io/Customer.csv";
    /**
     * Schreibt die Informationen eines Customers in eine CSV Datei.
     * @param customer Customer
     */
    public static void saveCustomer(Customer customer) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH_CSV);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(customer.getPrename() +","+ customer.getLastname() +"," +customer.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
            bufferedWriter.flush();
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
     *
     */
    public static Customer loadCustomer() throws FileNotFoundException {
        FileReader fileReader = new FileReader(FILE_PATH_CSV);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner s = new Scanner(bufferedReader);
        s.useDelimiter(",");
        Customer customer = new Customer(s.next(), s.next(), LocalDate.parse(s.next()));
        close(bufferedReader);
        close(fileReader);
        return customer;
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
