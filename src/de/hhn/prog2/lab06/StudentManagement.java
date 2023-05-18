package de.hhn.prog2.lab06;

import com.sun.jdi.request.DuplicateRequestException;

import java.util.HashMap;

public class StudentManagement {
    private static HashMap<Integer, Student> matriculatedStudents = new HashMap<>();

    public static void matriculate(String name, String prename, int matriculationNumber) throws DuplicateRequestException {
        if (matriculatedStudents.containsKey(matriculationNumber)) throw new DuplicateRequestException();
        else matriculatedStudents.put(matriculationNumber, new Student(name, prename, matriculationNumber));
    }

    public static void exmatriculate(int matriculationNumber) {
        if (matriculatedStudents.containsKey(matriculationNumber)) {
            matriculatedStudents.remove(matriculationNumber);
            System.out.println("Der Student wurde erfolgreich Exmatrikuliert.");
        }
        else System.out.println("Diese Matrikelnummer existiert bei uns nicht.");
    }

    public static void printList() {
        for (Student student : matriculatedStudents.values()) {
            System.out.println(student.getName() + " " + student.getPrename() + " Matrikelnummer: " + student.getMatriculationNumber());
        }
    }
}
