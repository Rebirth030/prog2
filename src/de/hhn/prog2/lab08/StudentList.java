package de.hhn.prog2.lab08;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * Klasse zur Darstellung einer Liste von Studenten, in einer ArrayList
 */
public class StudentList implements Iterator<Student> {

    private ArrayList<Student> students;
    private int index;
    private int maxStudents;

    /**
     * Konstruktor, erstellt die ArrayList und setzt die maximale Anzahl an Studenten.
     * setzt index auf 0.
     * @param maxStudents Integer
     */
    public StudentList(int maxStudents) {
        students = new ArrayList<>();
        this.index = 0;
        this.maxStudents = maxStudents;

    }

    /**
     * Fügt einen Studenten der Liste hinzu, wenn sie noch nicht voll ist.
     * @param student Student
     */
    public void addStudent(Student student) {
        if (students.size() >=maxStudents) {
            System.out.println("Die Liste ist voll");
        } else {
            students.add(student);
        }
    }

    /**
     * Gibt einen erstellten Iterator für die ArrayList zurück.
     * @return Iterator<Student>
     */
    public Iterator<Student> getIterator() {
        return students.iterator();
    }

    /**
     * Initialisiert die hasNext Methode von Iterator, mit dem Rückgabewert, ob der Aktuelle index größer ist als die länge der ArrayList.
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return  (index < students.size());
    }

    /**
     * Initialisiert die next Methode von Iterator und gibt das nächste Objekt in der ArrayList zurück.
     * @return Student
     */
    @Override
    public Student next() {
        Student student = students.get(index);
        index++;
        return student;
    }
}
