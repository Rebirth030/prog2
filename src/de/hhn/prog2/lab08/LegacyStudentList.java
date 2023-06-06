package de.hhn.prog2.lab08;


import java.util.Arrays;
import java.util.Iterator;

/**
 * Klasse zur Darstellung einer Liste von Studenten, in einem Array
 */
public class LegacyStudentList implements Iterator<Student> {

    private Student[] students;
    private int counter = 0;
    private int index;

    /**
     * Konstruktor, setzt die maximale Anzahl an Studenten, als Array-Größe.
     * setzt index auf 0.
     * @param maxStudents Integer
     */
    public LegacyStudentList(int maxStudents) {
        students = new Student[maxStudents];
        this.index = 0;

    }

    /**
     * Fügt einen Studenten der Liste hinzu, wenn sie noch nicht voll ist.
     * @param student Student
     */
    public void addStudent(Student student) {
        if (counter >= students.length) {
            System.out.println("Die Liste ist voll");
        } else {
            students[counter] = student;
            counter++;
        }
    }

    /**
     * Gibt einen erstellten Iterator für das Array zurück.
     * @return Iterator<Student>
     */
    public Iterator<Student> getIterator() {
        return Arrays.stream(students).iterator();
    }

    /**
     * Initialisiert die hasNext Methode von Iterator, mit dem Rückgabewert, ob der Aktuelle index größer ist als die länge des Arrays
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return  (index < students.length);
    }

    /**
     * Initialisiert die next Methode von Iterator und gibt das nächste Objekt im Array zurück.
     * @return Student
     */
    @Override
    public Student next() {
        Student student = students[index];
        index++;
        return student;
    }
}
