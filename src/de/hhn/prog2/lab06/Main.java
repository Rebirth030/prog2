package de.hhn.prog2.lab06;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * in der Main-Methode wird nur einmal interaction aufgerufen.
     * @param args String[]
     */
    public static void main(String[] args) {
        interaction();
    }

    /**
     * Interaction stellt die Interaktion mit dem Anwender da, über die Konsole.
     * Interaction ruf sich selber rekursiv auf, damit nicht für jede Aufgabe das Programm neu gestartet werden muss.
     */
    private static void interaction(){
        System.out.println("Was wolle sie tun?");
        System.out.println("Person Immatrikulieren: schreiben sie IM.");
        System.out.println("Person Exmatrikulieren: schreiben sie EX.");
        System.out.println("Eine Liste der Immatrikulierten Studenten Bekommen: schreiben sie LIST.");
        switch (scanner.next()) {
            case "IM" -> matriculate();
            case "EX" -> exmatriculate();
            case "LIST" -> StudentManagement.printList();
            default -> System.out.println("Bitte geben sie eine der Vorgegebenen Befehle ein.");
        }
        interaction();
    }

    /**
     * Ruft exmatriculate() in StudentManager auf, mit einer Eingabe.
     */
    private static void exmatriculate() {
        System.out.println("Bitte geben sie die Matrikelnummer des Studenten ein.");
        StudentManagement.exmatriculate(scanner.nextInt());

    }

    /**
     * Versucht matriculate() in StudentManager aufzurufen, mit Konsolen-Eingaben.
     */
    private static void matriculate() {
        System.out.println("Bitte geben sie nacheinander Nachname, Vorname und die sechsstellige Matrikelnummer an.");
        String name = scanner.next();
        String prename = scanner.next();
        int matriculationNumber = scanner.nextInt();
        try {
            StudentManagement.matriculate(name, prename, matriculationNumber);
        } catch (DuplicateRequestException e) {
            System.out.println("Die Matrikelnummer ist schon immatrikuliert.");
        }
    }
}
