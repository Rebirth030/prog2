package de.hhn.prog2.lab06;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.HashMap;

/**
 * Managed zwischen die Studenten in einer HashMap.
 */
public class StudentManagement {
    private static HashMap<Integer, Student> matriculatedStudents = new HashMap<>();

    /**
     * Guckt, ob die übergebene Matrikelnummer in der HashMap schon vorhanden ist, falls nicht, wird versucht einen neuen Studenten in die Liste einzutragen.
     * @param name String
     * @param prename String
     * @param matriculationNumber Integer
     * @throws DuplicateRequestException DuplicateRequestException
     */
    public static void matriculate(String name, String prename, int matriculationNumber) throws DuplicateRequestException {
        if (matriculatedStudents.containsKey(matriculationNumber)) throw new DuplicateRequestException();
        else {
            try {
                matriculatedStudents.put(matriculationNumber, new Student(name, prename, matriculationNumber));
            } catch (IllegalArgumentException e) {
                System.out.println("Bitte geben sie valide Werte für den Vor-, Nachnamen und Matrikelnummer ein.");
            }
        }
    }

    /**
     * Wenn die übergebene Matrikelnummer, als Key, in der HashMap vorhanden wird, wird der Eintrag gelöscht.
     * @param matriculationNumber Integer
     */
    public static void exmatriculate(int matriculationNumber) {
        if (matriculatedStudents.containsKey(matriculationNumber)) {
            matriculatedStudents.remove(matriculationNumber);
            System.out.println("Der Student wurde erfolgreich Exmatrikuliert.");
        }
        else System.out.println("Diese Matrikelnummer existiert bei uns nicht.");
    }

    /**
     * gibt den Inhalt der HashMap geordnet auf der Konsole aus.
     */
    public static void printList() {
        for (Student student : matriculatedStudents.values()) {
            System.out.println(student.getName() + " " + student.getPrename() + " Matrikelnummer: " + student.getMatriculationNumber());
        }
    }
}
