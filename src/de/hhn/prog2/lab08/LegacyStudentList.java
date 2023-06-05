package de.hhn.prog2.lab08;


import java.util.Arrays;
import java.util.Iterator;

public class LegacyStudentList implements Iterator<Student> {

    private Student[] students;
    private int counter = 0;
    private int index;

    public LegacyStudentList(int maxStudents) {
        students = new Student[maxStudents];
        this.index = 0;

    }

    public void addStudent(Student student) {
        if (counter >= students.length) {
            System.out.println("Die Liste ist voll");
        } else {
            students[counter] = student;
            counter++;
        }
    }

    public Iterator<Student> getIterator() {
        return Arrays.stream(students).iterator();
    }

    @Override
    public boolean hasNext() {
        return  (index < students.length);
    }

    @Override
    public Student next() {
        Student student = students[index];
        index++;
        return student;
    }
}
